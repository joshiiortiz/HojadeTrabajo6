/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoja6;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Joseline
 */
public class Main {

/**
* @param args the command line arguments
//HashSet: no tiene un orden predecible
//TreeSet: ordena los elementos alfabeticamente por comparaciones
//LinkedHashSet: en el orden en que fueron ingresados
*/

    public static void main(String[] args) {
        //pidiendo el tipo de implementacion que desea usar
        System.out.println ("           ...: Bienvenido al Programa:...");	//saludo al usuario
        Scanner entrada = new Scanner (System.in);      //Creación de un objeto Scanner
        String mensaje = "Por favor introduzca el tipo de implementacion SET que desea usar: <hashSet>, <treeSet>, <linkedHashSet> ";
        System.out.println (mensaje);     //pido al usuario su eleccion
        String tipo = "";       //creo la variable para guardar el dato
        tipo = entrada.nextLine ();
        while(!tipo.equals("hashSet") && !tipo.equals("treeSet") && !tipo.equals("linkedHashSet")){
            System.out.println (mensaje);	//pido al usuario su eleccion
            tipo = "";      //creo la variable para guardar el dato
            tipo = entrada.nextLine ();
        }

        //numero de personas a ingresar
        System.out.println ("Ingrese el numero de personas a ingresar:");       //se ingresa el numero de personas a ingresar
        String  numero = "";        //creo la variable para guardar el dato
        numero = entrada.nextLine ();

      //creando los objetos para los conjuntos
        SetFactory eleccion= new SetFactory();			//creando el objeto setFactory
        Set<String> programadoresWeb;		//creando un generico para las 3 implementaciones
        Set<String> programadoresJava;		
        Set<String> programadoresCelular;	
        
        programadoresWeb = null;
        programadoresJava = null;
        programadoresCelular = null;
        
        Set<String> preg1 = null;	//creando las listas para dar la respuesta
        Set<String> preg2 = null ;	
        Set<String> preg3 = null;	
        Set<String> preg4 = null;	
        Set<String> preg5 = null;	
        Set<String> preg6 = null;	

        programadoresWeb= eleccion.ObtenerSet(tipo);	//definiendo todas los grupos del mismo tipo
        programadoresJava= eleccion.ObtenerSet(tipo);
        programadoresCelular= eleccion.ObtenerSet(tipo);

        //definiendo los grupas para dar las respuestas a las preguntas del rubrica
        preg1=eleccion.ObtenerSet(tipo);
        preg2=eleccion.ObtenerSet(tipo);
        preg3=eleccion.ObtenerSet(tipo);
        preg4=eleccion.ObtenerSet(tipo);
        preg5=eleccion.ObtenerSet(tipo);
        preg6=eleccion.ObtenerSet(tipo);

        //numero de ingresos
        int cont=0;
            String trabajo1 = "";       //creo la variable para guardar el dato
            String trabajo2 = "";       
            String trabajo3 = "";       
            String nombre = "";		
        
        while (cont<Integer.parseInt(numero)){
            cont=cont+1;
            //pidiendo datos
            System.out.println ("Ingrese su nombre:");      //pido al usuario su nombre
            nombre = entrada.next(); 

            //pidiendo datos
            System.out.println ("Pertenece al grupo desarrolador WEB (Si/No): ");	//pido al usuario su tipo de grupo
            trabajo1 = entrada.next();
            while (!trabajo1.equals("No") && !trabajo1.equals("Si")){
                //pidiendo datos
                System.out.println ("Si pertenece al grupo desarrollador WEB ingrese <Si> de lo contrario ingrese <NO>: ");	//pido al usuario su tipo de grupo
                trabajo1 = "";      //creo la variable para guardar el dato
                trabajo1 = entrada.next();
            }
            //pidiendo datos
            System.out.println ("Pertenece al grupo desarrolador JAVA (Si/No): ");	//pido al usuario su tipo de grupo
            trabajo2 = entrada.next();
            while (!trabajo2.equals("No") && !trabajo2.equals("Si")){
                //pidiendo datos
                System.out.println ("Si pertenece al grupo desarrollador JAVA ingrese <Si> de lo contrario ingrese <NO>: ");	//pido al usuario su tipo de grupo
                trabajo2 = "";      //creo la variable para guardar el dato
                trabajo2 = entrada.next();
            }
            //pidiendo datos
            System.out.println ("Pertenece al grupo desarrolador CELULAR (Si/No): ");	//pido al usuario su tipo de grupo
            trabajo3 = entrada.next();
            while (!trabajo3.equals("No") && !trabajo3.equals("Si")){
                //pidiendo datos
                System.out.println ("Si pertenece al grupo desarrollador CELULAR ingrese <Si> de lo contrario ingrese <NO>: ");	//pido al usuario su tipo de grupo
                trabajo3 = "";      //creo la variable para guardar el dato
                trabajo3 = entrada.next();
            }
            //comparaciones para los conjuntos o grupos
            if (trabajo1.equals("Si")){     //se compara la eleccion hecha por el usuario
                programadoresWeb.add(nombre);       //se guarda en el conjunto
            }
            else if(trabajo2.equals("Si")){         //se se compara la eleccion hecha por el usuario
                programadoresJava.add(nombre);      //se guarda en el conjunto
            }
            else if(trabajo3.equals("Si")){     	//se se compara la eleccion hecha por el usuario
                programadoresCelular.add(nombre);       //se guarda en el conjunto
            }
        }

        //pregunta1: se muestran las intersecciones
        preg1.addAll(programadoresWeb);
        preg1.retainAll(programadoresCelular);
        preg1.retainAll(programadoresJava);
        System.out.println("Interseccion entre los 3 conjuntos: "+preg1);

        //pregunta2: se muestra los trabajadores en java y no en web
        preg2.addAll(programadoresJava);
        preg2.removeAll(programadoresWeb);
        System.out.println("Trabajadores en Java pero no Web: "+preg2);

        //pregunta3: web y celulares, pero no java
        preg3.addAll(programadoresWeb);
        preg3.retainAll(programadoresCelular);
        preg3.removeAll(programadoresJava);
        System.out.println("Trabajadores en Java y Celulares pero no Web: "+preg3);

        //pregunta4: web o celulares pero no java
        preg4.addAll(programadoresCelular);
        preg4.addAll(programadoresWeb);
        preg4.removeAll(programadoresJava);
        System.out.println("Trabajadores en Web o Celulares, pero no en Java: "+preg4);

        //pregunta5: es subconjunto java de web
        boolean contiene= programadoresJava.containsAll(programadoresWeb);
        if (contiene==true){
            System.out.println("Java si contiene a los programadores Web, Si lo contiene!");
        }else{
            System.out.println("Java No contiene a los programadores Web, No lo contiene!");
        }

        //pregunta6: catidad más grande desarrolladores y sus nombre
        int tamaño1= programadoresJava.size();
        int tamaño2= programadoresCelular.size();
        int tamaño3= programadoresWeb.size();
        String tip="";
        if (tamaño1>tamaño2 && tamaño1>tamaño3){
            System.out.println("Java tiene la cantidad mas grande de desarrolladores"+ programadoresJava);
            preg6.addAll(programadoresJava);
            tip="JAVA";
        }else if(tamaño2>tamaño1 && tamaño2> tamaño3){
            System.out.println("Celular tiene la cantidad mas grande de desarrolladores"+ programadoresCelular);
            preg6.addAll(programadoresCelular);
            tip="CELULAR";
        }else{
            System.out.println("Web tiene la cantidad mas grande de desarrolladores"+ programadoresWeb);
            preg6.addAll(programadoresWeb);
            tip= "WEB";
        }

        //pregunta7: cantidad mayor y en orden ascendente
        Set ascendente= new TreeSet(preg6);
        System.out.println("La cantidad mas grande de desarrolladores es: "+tip+ ascendente);
    }
}