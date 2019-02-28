function pause(){
   read -p "$*"
}
 

java -jar /home/jonathan/Documentos/7S/compi/Librerias/jflex-full-1.7.0.jar A_Lexico.jflex --encoding utf-8

pause '\nPress [Enter] key to continue...\n'

java -jar /home/jonathan/Documentos/7S/compi/Librerias/java-cup-11b.jar -parser analisis_sintactico -symbols simbolos A_Sintactico.cup



