
package binarioadecimal.jflex;
import binarioadecimal.cup.Simbolos;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexico
%cupsym Simbolos
%cup
%cupdebug
%line
%column

/*Identifiers*/
Bin = [01]


%%//Reglas Lexicas

<YYINITIAL>{
        "."                 {return new Symbol(Simbolos.PUNTO, yycolumn,yyline,yytext());}
        {Bin}                 {return new Symbol(Simbolos.BIN, yycolumn,yyline,yytext());}
        [ \t\r\n\f]                            {}
        .                                            {return new Symbol(Simbolos.ERROR,yycolumn,yyline,yytext());} 
 
}