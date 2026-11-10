param([Parameter(Mandatory = $true)][string]$AspectJHome)
$ErrorActionPreference = 'Stop'
$repo = Split-Path $PSScriptRoot -Parent
$tools = Join-Path $AspectJHome 'aspectjtools.jar'
$runtime = Join-Path $AspectJHome 'aspectjrt.jar'
if (!(Test-Path $tools) -or !(Test-Path $runtime)) {
    throw 'La carpeta debe contener aspectjtools.jar y aspectjrt.jar (AspectJ 1.9.25).'
}
$out = Join-Path $repo 'target/adapter'
New-Item -ItemType Directory -Force $out | Out-Null
$sources = @('src/main/java/Impresora.java', 'src/main/java/ImpresoraAntigua.java',
    'src/main/java/GestorImpresiones.java', 'src/adapter/AdapterAspect.aj',
    'src/adapter/java/MainAOP.java') | ForEach-Object { Join-Path $repo $_ }
& java -cp $tools org.aspectj.tools.ajc.Main -17 -encoding UTF-8 -showWeaveInfo -classpath $runtime -d $out @sources
if ($LASTEXITCODE -ne 0) { throw 'Error de compilación de Adapter AOP.' }
& java -cp "$out;$runtime" MainAOP
if ($LASTEXITCODE -ne 0) { throw 'Error en la prueba de Adapter AOP.' }
