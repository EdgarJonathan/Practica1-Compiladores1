/*-----------1ra Area: Codigo de Usuario-------------------------------*/

//--------------> Paquetes, importaciones
package Analisis;
import java_cup.runtime.*;
import java.util.LinkedList;




/*-----------2da Area: Opciones y Declaraciones-------------------------------*/
%%  

%{
    //--------->Codigo de Usuario en sintaxis Java
    
    public static LinkedList<TError> tablaEL = new LinkedList<TError>();
%}

//------------>Directivas de JFlex
%public
%class Analizador_Lexico
%cupsym simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode
%8bit


//-----> Simbolos
//simbolos

/* COMA   = ","
PTCOMA = ";" */

//------------------>Expresiones Regulares




SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

letra    = [A-Za-zñÑ]
entero  = [0-9]+
decimal = {entero}+"."+{entero}

identificador = {letra}({letra}|{entero}|"_")*

//identificador =  [A-Za-zñÑ]

cadena = "\""~"\""
comentS = "//" ~(\n|\r)     //Comentario simple
comentM = "/*"~ "*/"        //Comentario Multilinea


//------------------> Estados
%%
/*-----------3ra Area: Reglas Lexicas-------------------------------*/

//------------------------> colores 
<YYINITIAL> "\"rojo\"" {System.out.println("Palabra Reservada: ["+yytext()+"] Color Rojo"); 
                    return new Symbol(simbolos.colorrojo,yyline,yychar, yytext());}

<YYINITIAL> "\"amarillo\"" {System.out.println("Palabra Reservada: ["+yytext()+"] Color Amarillo"); 
                    return new Symbol(simbolos.coloramarillo,yyline,yychar, yytext());}

<YYINITIAL> "\"naranja\"" {System.out.println("Palabra Reservada: ["+yytext()+"] Color Naranja"); 
                    return new Symbol(simbolos.colornaranja,yyline,yychar, yytext());}

<YYINITIAL> "\"azul\"" {System.out.println("Palabra Reservada: ["+yytext()+"] Color Azul"); 
                    return new Symbol(simbolos.colorazul,yyline,yychar, yytext());}         

<YYINITIAL> "\"negro\"" {System.out.println("Palabra Reservada: ["+yytext()+"] Color Negro"); 
                    return new Symbol(simbolos.colornegro,yyline,yychar, yytext());}    

<YYINITIAL> "\"verde\"" {System.out.println("Palabra Reservada: ["+yytext()+"] Color Verde"); 
                    return new Symbol(simbolos.colorverde,yyline,yychar, yytext());}    

//------------------->Simbolos

<YYINITIAL>     ":" {System.out.println("Simbolo: ["+yytext()+"] dos puntos");
                    return new Symbol(simbolos.dospuntos,yyline,yychar, yytext());} 

<YYINITIAL>     "," {System.out.println("Simbolo: ["+yytext()+"] dos puntos");
                    return new Symbol(simbolos.coma,yyline,yychar, yytext());}                     

<YYINITIAL>     ";" {System.out.println("SImbolo: ["+yytext()+"] punto y coma"); 
                    return new Symbol(simbolos.ptcoma,yyline,yychar, yytext());} 

<YYINITIAL>     "{" {System.out.println("Simbolo: ["+yytext()+"] llave derecha");  
                    return new Symbol(simbolos.llaveA,yyline,yychar, yytext());} 

<YYINITIAL>     "}" {System.out.println("Simbolo: ["+yytext()+"] llave izquierda"); 
                    return new Symbol(simbolos.llaveC,yyline,yychar, yytext());}

<YYINITIAL>     "=" {System.out.println("Simbolo: ["+yytext()+"] igual"); 
                    return new Symbol(simbolos.igual,yyline,yychar, yytext());}

<YYINITIAL>     "[" {System.out.println("Simbolo: ["+yytext()+"] Corchete Abierto"); 
                    return new Symbol(simbolos.corcheteA,yyline,yychar, yytext());}

<YYINITIAL>     "]" {System.out.println("Simbolo: ["+yytext()+"] Corchete Cerrado"); 
                    return new Symbol(simbolos.corcheteC,yyline,yychar, yytext());}

<YYINITIAL>     "?" {System.out.println("Simbolo: ["+yytext()+"] Interrogacion Cerrada"); 
                    return new Symbol(simbolos.interrogacionC,yyline,yychar, yytext());}

<YYINITIAL>     "¿" {System.out.println("Simbolo: ["+yytext()+"] Interrogacion Abierta"); 
                    return new Symbol(simbolos.interrogacionA,yyline,yychar, yytext());}                                     

//------------------------> Palabras reservadas---------------------

<YYINITIAL> "string" {System.out.println("Palabra Reservada: ["+yytext()+"] string"); 
                    return new Symbol(simbolos.tkstring,yyline,yychar, yytext());}

<YYINITIAL> "int" {System.out.println("Palabra Reservada: ["+yytext()+"] int"); 
                    return new Symbol(simbolos.tkint,yyline,yychar, yytext());}

<YYINITIAL> "DefinirGlobales" {System.out.println("Palabra Reservada: ["+yytext()+"] DefenirGlobales"); 
                    return new Symbol(simbolos.defGlobal,yyline,yychar, yytext());}

<YYINITIAL> "ID" {System.out.println("Palabra Reservada: ["+yytext()+"] id"); 
                    return new Symbol(simbolos.id,yyline,yychar, yytext());}

<YYINITIAL> "titulo" {System.out.println("Palabra Reservada: ["+yytext()+"] titulo"); 
                    return new Symbol(simbolos.titulo,yyline,yychar, yytext());}

<YYINITIAL> "titulox" {System.out.println("Palabra Reservada: ["+yytext()+"] titulox"); 
                    return new Symbol(simbolos.titulox,yyline,yychar, yytext());}

<YYINITIAL> "tituloy" {System.out.println("Palabra Reservada: ["+yytext()+"] tituloy"); 
                    return new Symbol(simbolos.tituloy,yyline,yychar, yytext());}

<YYINITIAL> "ejex" {System.out.println("Palabra Reservada: ["+yytext()+"] ejex"); 
                    return new Symbol(simbolos.ejex,yyline,yychar, yytext());}

<YYINITIAL> "ejey" {System.out.println("Palabra Reservada: ["+yytext()+"] ejey"); 
                    return new Symbol(simbolos.ejey,yyline,yychar, yytext());}
                    
<YYINITIAL> "puntosxy" {System.out.println("Palabra Reservada: ["+yytext()+"] ejey"); 
                        return new Symbol(simbolos.puntosxy,yyline,yychar, yytext());}

<YYINITIAL> "GraficaBarras" {System.out.println("Palabra Reservada: ["+yytext()+"] GraficaBarras"); 
                    return new Symbol(simbolos.graficabarras,yyline,yychar, yytext());}

<YYINITIAL> "GraficaLineas" {System.out.println("Palabra Reservada: ["+yytext()+"] GraficaLineas"); 
                    return new Symbol(simbolos.graficalinea,yyline,yychar, yytext());}

<YYINITIAL> "Nombre" {System.out.println("Palabra Reservada: ["+yytext()+"] Nombre"); 
                    return new Symbol(simbolos.nombre,yyline,yychar, yytext());}

<YYINITIAL> "Color" {System.out.println("Palabra Reservada: ["+yytext()+"] Color"); 
                    return new Symbol(simbolos.color,yyline,yychar, yytext());}

<YYINITIAL> "Grosor" {System.out.println("Palabra Reservada: ["+yytext()+"] Grosor"); 
                    return new Symbol(simbolos.grosor,yyline,yychar, yytext());}

<YYINITIAL> "Puntos" {System.out.println("Palabra Reservada: ["+yytext()+"] Puntos"); 
                    return new Symbol(simbolos.puntos,yyline,yychar, yytext());}

<YYINITIAL> "DefinirXYLine" {System.out.println("Palabra Reservada: ["+yytext()+"] DefinirXYLine"); 
                    return new Symbol(simbolos.defxyline,yyline,yychar, yytext());}

<YYINITIAL> "Galeria" {System.out.println("Palabra Reservada: ["+yytext()+"] Galeria"); 
                    return new Symbol(simbolos.galeria,yyline,yychar, yytext());}

//------------------------> Operacion Aritmeticas
<YYINITIAL>     "+" {System.out.println("Operacion: ["+yytext()+"] Suma"); 
                    return new Symbol(simbolos.suma,yyline,yychar, yytext());}

<YYINITIAL>     "-" {System.out.println("Operacion: ["+yytext()+"] Resta"); 
                    return new Symbol(simbolos.resta,yyline,yychar, yytext());} 

<YYINITIAL>     "*" {System.out.println("OPeracion: ["+yytext()+"] Multipicacion"); 
                    return new Symbol(simbolos.por,yyline,yychar, yytext());}    

<YYINITIAL>     "/" {System.out.println("OPeracion: ["+yytext()+"] Division"); 
                    return new Symbol(simbolos.div,yyline,yychar, yytext());}    

<YYINITIAL>     "(" {System.out.println("Simbolo: ["+yytext()+"] Parentesis Abierto"); 
                    return new Symbol(simbolos.parA,yyline,yychar, yytext());}  

<YYINITIAL>     ")" {System.out.println("SImbolo: ["+yytext()+"] Parentesis Cerrado"); 
                    return new Symbol(simbolos.parC,yyline,yychar, yytext());}  

//----------------------->Simbolos Expresiones regulares
<YYINITIAL>     {cadena} {System.out.println("Encontro: ["+yytext()+"] Cadena de Texto"); 
                         return new Symbol(simbolos.cadena,yyline,yychar, yytext());} 
                         
<YYINITIAL>     {entero} {System.out.println("Encontro: ["+yytext()+"] Numero entero"); 
                         return new Symbol(simbolos.entero,yyline,yychar, yytext());} 
                         
<YYINITIAL>     {decimal} {System.out.println("Encontro: ["+yytext()+"] Numero decimal"); 
                         return new Symbol(simbolos.entero,yyline,yychar, yytext());}  

<YYINITIAL>     {identificador} {System.out.println("Encontro: ["+yytext()+"] token id"); 
                         return new Symbol(simbolos.tk_idedntificador,yyline,yychar, yytext());} 

//---------------->Espacios
<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}
<YYINITIAL> {comentM} {}
<YYINITIAL> {comentS} {}



 //--------------->Errores Lexicos
<YYINITIAL> .                   {System.out.println("Error Lexico: "+yytext()+", Linea: "+yyline+", Col"+yycolumn);
                     TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                     tablaEL.add(datos);}



