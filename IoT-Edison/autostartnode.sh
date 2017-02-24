#!/bin/sh
# /etc/init.d/autostartnode
 
### BEGIN INIT INFO
# Provides: autostartnode
# Required-Start: $local_fs $remote_fs
# Required-Stop: $local_fs $remote_fs
# Default-Start: 2 3 4 5
# Default-Stop: 0 1 6
# Short-Description: Démarrage automatique des scripts Node.JS
# Description: Démarrage automatique des scripts Node.JS
### END INIT INFO
 
lancement(){
    # On créé la session 'screen' en mode détaché
    screen -dmS nomScreen
    # On se déplace dans le chemin où se trouve nos scripts .js (Node.JS)
    screen -S nomScreen -p 0 -X stuff "cd /home/root/node_modules/aws-iot-device-sdk/$(printf \\r)"
    # On lance notre script à l'aide de la commande 'node'
    screen -S nomScreen -p 0 -X stuff "/usr/bin/node Edison-JS-Sample.js$(printf \\r)"
 
    sleep 5 # On patiente 3s le temps que le script s'execute
 
    # On vérifie que notre session screen se soit bien lancée et on affiche le résultat
    #if ! screen -list | grep -q "nomScreen"
     #   then
       # echo "AutoStartNode : Echec lors du lancement de 'nomScreen'"
    # else
       # echo "AutoStartNode : Lancement de 'nomScreen' reussi"
    # fi
 
}
 
lancement
 
exit 0