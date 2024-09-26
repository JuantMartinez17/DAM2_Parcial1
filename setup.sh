# Verificar si ya existe apikeys.properties
if [ -f "./apikey.properties" ]; then
    echo "apikey.properties ya existe. No es necesario realizar modificaciones"
else
    # Crear el archivo apikeys.properties
    touch apikey.properties
    echo "API_KEY=insert_apikey" > apikey.properties
    echo "Archivo apikey.properties creado."
fi