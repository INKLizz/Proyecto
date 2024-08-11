/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sabillon_cristina_proyecto1;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Laura Sabillon
 */
public class Sabillon_Cristina_Proyecto1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        
        //INVENTARIO
        int azucar = 0, avena = 0, trigo = 0, maiz = 0, cantidad_azucar = 0, cantidad_avena = 0, cantidad_trigo = 0, cantidad_maiz = 0;
        
        //VENTA
        int  azucar_venta = 30, avena_venta = 25, trigo_venta = 32, maiz_venta = 20, cantidad = 0;
        String codigo = "", buy = "", continuar = "";
        boolean producto_disponible = true;
        
        //COMPRA
        int azucar_compra = 25, avena_compra_C = 22, avena_compra_B = 20, trigo_compra = 30, maiz_compra = 18;
        
        //DINERO CAJA
        double caja = 0, dinero = 0;
        String ingresar = "";
        
        //CAJA
        String si_no = "";
        boolean caja_abierta = false, open_first = true, valid = false;
        int deposito = 0; 
        double deposito_posible = 0;
        
        //FACTURA
        String producto = "", Factura = "";
        int precio = 0;
        double subtotal = 0, total = 0, impuesto = 0, descuento = 0, subtotal_final = 0, descuento_final = 0;     
        
        //REPORTES
        int contador_ventas = 0, contador_compras = 0, mayor_cantidad = 0, cantidad2 = 0, cantidad3 = 0, cantidad4 = 0;
        double total_ventas = 0, total_compras = 0, valor_compra = 0, valor_ventas = 0, mayorCompra = 0, mayorVenta = 0;
        String producto_estrella = "", producto_2 = "", producto_3 = "", producto_4 = "";
        
        // ** MENU **    
        while (true){
        System.out.println("\n|------------------------------|");
        System.out.println("|       **** MENU ****         |");
        System.out.println("|------------------------------|");
        System.out.println("| a. Caja                      |");
        System.out.println("| b. Ventas                    |");
        System.out.println("| c. Compras                   |");
        System.out.println("| d. Reportes                  |");
        System.out.println("| e. Cierre de Caja            |");        
        System.out.println("| f. Salir del Sistema         |");
        System.out.println("|------------------------------|");
        System.out.println("Favor ingresar la letra de la ventana que quiere ingresar (a, b, c, d, e, f).");
        String ventana = scan.next();

        //RESTRICCIÓN
        while (!ventana.equalsIgnoreCase("a") && !ventana.equalsIgnoreCase("b")
                 && !ventana.equalsIgnoreCase("c") && !ventana.equalsIgnoreCase("d") 
                && !ventana.equalsIgnoreCase("e") && !ventana.equalsIgnoreCase("f")) {
            System.out.println("ERROR.Debe ingresar (a, b, c, d, e, f). Intente de nuevo");
            ventana = scan.next();
        }        
        
        // ** VENTANA DE CAJA **
        if (ventana.equalsIgnoreCase("a")) {
            caja_abierta = true;
            System.out.println("\n        *** CAJA ***     ");
            System.out.println("Cantidad de dinero actual : Lps." + String.format("%.2f",caja));

            //PRIMERA VES ABRIENDO CAJA
            if (open_first == true) {
                System.out.println("Ingrese dinero:");
                
                while(!valid){
                    try{
                    dinero = scan.nextDouble();
                    valid = true;
                    }catch(InputMismatchException e){
                        System.out.println("Tiene que ingresar un numero. Intente de nuevo.");
                        scan.next();
                    }         
                }
                    open_first = false;
            } else {
                
                //CAJA YA ABIERTA
                System.out.println("Desea ingresar dinero? SI/NO");
                ingresar = scan.next();

                //RESTRICCIÓN
                while (!ingresar.equalsIgnoreCase("si") && !ingresar.equalsIgnoreCase("no")) {
                    System.out.println("ERROR. Solo se puede ingresar si o no. Intente de nuevo.");
                    ingresar = scan.next();
                }
                
                //DINERO AÑADIR 
                if (ingresar.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese la cantidad de dinero:");
                    valid = false;
                    
                    while(!valid){
                        try{
                        dinero = scan.nextDouble();
                        valid = true;
                        }catch(InputMismatchException e){
                            System.out.println("Tiene que ingresar un numero. Intente de nuevo.");
                            scan.next();
                        }         
                    }
                } else {
                    continue;
                }
            }

            //DINERO RESTRICCIÓN DE (0) Y (-)
            while (dinero <= 0) {
                if (dinero < 0) {
                    System.out.println("No se permiten numeros negativos. Intente de nuevo.");
                } else if (dinero == 0 ) {
                    System.out.println("Tiene que ingresar una cantidad. Intente de nuevo.");
                }
                valid = false;
                while(!valid){
                    try{
                    dinero = scan.nextDouble();
                    valid = true;
                    }catch(InputMismatchException e){
                        System.out.println("Tiene que ingresar un numero. Intente de nuevo.");
                        scan.next();
                    }         
                }
            }
            caja += dinero;
        }
        
        // ** VENTANA DE VENTAS **
        if (ventana.equalsIgnoreCase("b")){
            if (caja_abierta == false){
                System.out.println("Aun no ha abierto la Caja.");
                continue;
            }            
            else if (azucar == 0 && maiz == 0 && avena == 0 && trigo == 0){
                System.out.println("No tiene productos para poder vender al cliente.");
                continue;
            }
            //FACTURA
            String producto1 = "", producto2 = "", producto3 = "", producto4= "";
            int cantidad_1 = 0, cantidad_2 = 0 , cantidad_3 = 0, cantidad_4 = 0,
                precio_1 = 0, precio_2 = 0, precio_3 = 0, precio_4 = 0;
            double subtotal_1 = 0, subtotal_2 = 0, subtotal_3 = 0, subtotal_4 = 0;                          
            
            System.out.println("\n|---------------------------------------------------------");
            System.out.println("|  Tipo de Cliente  |  Productos disponibles a Cliente  |");
            System.out.println("|---------------------------------------------------------");
            System.out.println("|     Cliente A     |  Azucar, Avena, Trigo, Maiz       |");
            System.out.println("|     Cliente B     |  Azucar, Avena, Trigo             |");
            System.out.println("|     Cliente C     |  Maiz                             |");
            System.out.println("|----------------------------------------------------------");            
            System.out.println("Favor ingresar la letra de el tipo de Cliente ( A, B, C ).");
            System.out.println("Escribir 'e' para volver al menu principal.");
            String cliente = scan.next(); 
            
            //RESTRICCIÓN
            while (!(cliente.equalsIgnoreCase("a") ||cliente.equalsIgnoreCase("b") 
                    || cliente.equalsIgnoreCase("c") || cliente.equalsIgnoreCase("e"))){ 
                System.out.println("ERROR. Debe ingresar (A, B, C). Intente de nuevo");
                cliente = scan.next();
            }
            
            //CLIENTE NO TIENE PRODUCTOS        
            if (cliente.equals("c") && maiz == 0){
                System.out.println("No hay producto para vender al cliente tipo C.");
                continue;
            }    
            if (cliente.equals("b")&& avena == 0 && trigo == 0 && azucar == 0){
                System.out.println("No hay producto para vender al cliente B.");
                continue;
            }
            
            //SALIR
            if (cliente.equalsIgnoreCase("e")){
                continue;
            }
            
            //CLIENTES TIPOS Y PRODUCTOS DISPONIBLES            
            while (true){               
                
                // --- CLIENTE A ---
                if (cliente.equalsIgnoreCase("a")){    
                    System.out.println("\n------------------------------------------------------------------------");
                    System.out.println("|  Codigo     |  Producto  |  Precio por 1 kg   |     Kg. Dispomible  |");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("     1        |   Azucar   |     Lps. 30        |     Kg. " + azucar);
                    System.out.println("     2        |   Avena    |     Lps. 25        |     Kg. " + avena);
                    System.out.println("     3        |   Trigo    |     Lps. 32        |     Kg. " + trigo);
                    System.out.println("     4        |   Maiz     |     Lps. 20        |     Kg. " + maiz);
                    System.out.println("------------------------------------------------------------------------");
                }
                // --- CLIENTE B ----
                else if (cliente.equalsIgnoreCase("b")){
                    System.out.println("\n------------------------------------------------------------------------");
                    System.out.println("|  Codigo     |  Producto  |  Precio por 1 kg   |     Kg. Dispomible  |");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("     1        |   Azucar   |     Lps. 30        |     Kg. " + azucar);
                    System.out.println("     2        |   Avena    |     Lps. 25        |     Kg. " + avena);
                    System.out.println("     3        |   Trigo    |     Lps. 32        |     Kg. " + trigo);
                    System.out.println("------------------------------------------------------------------------");
                }
                // --- CLIENTE C ----
                else if (cliente.equalsIgnoreCase("c")){
                    System.out.println("\n------------------------------------------------------------------------");
                    System.out.println("|  Codigo     |  Producto  |  Precio por 1 kg   |     Kg. Dispomible  |");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("     4        |   Maiz     |     Lps. 20        |     Kg. " + maiz);
                    System.out.println("------------------------------------------------------------------------");
                }
                
                //INPUT
                producto_disponible = true;
                System.out.println("Favor ingrear el numero del codigo del producto que desea comprar.");
                codigo = scan.next();                                    

                //RESTRICCIÓN
                while (true) {
                    
                    //RESTRICCIÓN A
                    if (cliente.equalsIgnoreCase("a")){
                        if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3") 
                        || codigo.equals("4")) {
                            break;
                            } else {
                            System.out.println("ERROR. Este codigo no existe,solo son validos codigo (1,2,3,4) intente de nuevo.");
                            }
                            codigo = scan.next();
                        }
                    
                    // RESTRICCIÓN B
                    else if (cliente.equalsIgnoreCase("b")){
                        if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3") 
                            || codigo.equals("4")) {
                            if (codigo.equals("4")) {
                            System.out.println("Este producto no esta disponible al Cliente Tipo B, escoja otro. Intente de nuevo.");
                            } else {
                            break;
                            }
                            } else {
                            System.out.println("ERROR. Este codigo no existe,solo son validos codigo (1,2,3,4) intente de nuevo.");
                            }
                            codigo = scan.next();
                        }
                    
                    //RESTRICCIÓN C
                    else if (cliente.equalsIgnoreCase("c")){
                        if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3") 
                           || codigo.equals("4")) {
                            if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3")) {
                            System.out.println("Este producto no esta disponible al Cliente Tipo C, escoja otro. Intente de nuevo.");
                            } else {
                                break;
                            }
                            } else {
                            System.out.println("ERROR. Este codigo no existe,solo son validos codigo (1,2,3,4) intente de nuevo.");
                            }
                            codigo = scan.next();                                                  
                        }
                              
                    }

                    //PRODUCTOS Y PRECIO ESCOGIDO, AL IGUAL QUE CANTIDAD
                    if (codigo.equals("1")){
                        producto = "Azucar";
                        precio = azucar_venta;
                    }
                    else if (codigo.equals("2")){
                        producto = "Avena";
                        precio = avena_venta;
                    }
                    else if (codigo.equals("3")){
                        producto = "Trigo";
                        precio= trigo_venta;   
                    }
                    else if (codigo.equals("4")){
                        producto = "Maiz";
                        precio = maiz_venta;  
                    }
 
                    //FALTA DE INVENTARIO
                    if (codigo.equals("1") && azucar == 0 || codigo.equals("2") && avena == 0 
                        || codigo.equals("3") && trigo == 0 || codigo.equals("4") && maiz == 0){
                        System.out.println("El producto no esta disponible.");
                        continue;
                    }
                    
                    //CANTIDAD A VENDER
                    System.out.println("Cuantos kgs va a comprar?");
                    valid = false;
                    
                    while (!valid){
                        try{
                            cantidad = scan.nextInt();
                            valid = true;
                        }catch (InputMismatchException e){
                            System.out.println("Debe que ingresar un numero. Intente de nuevo.");
                            scan.next();
                        }
                    }
                    
                    while ( cantidad < 0){
                        System.out.println("No se permiten numeros negativos.");
                        valid = false;                   
                        while (!valid){
                            try{
                            cantidad = scan.nextInt();
                            valid = true;
                             }catch (InputMismatchException e){
                                System.out.println("Debe que ingresar un numero. Intente de nuevo.");
                                scan.next();
                                }
                            }                   
                        } 
          
                    //1 AZUCAR 
                    if (codigo.equals("1") && cantidad > azucar){
                        System.out.println("Solo hay disponible Kg. " + azucar + " de azucar, quiere continuar con su compra? SI/NO");
                        continuar = scan.next();
                        
                        while(!(continuar.equalsIgnoreCase("si") || continuar.equalsIgnoreCase("no"))){
                            System.out.println("Favor ingresar SI/NO. No se permiten otro tipo de ingreso.");
                            continuar = scan.next();
                        }
                        if (continuar.equalsIgnoreCase("si")){
                            cantidad = azucar;
                            azucar = 0;
                            cantidad_azucar += cantidad;                           
                        }
                        else if (continuar.equalsIgnoreCase("no")){
                            cantidad = 0;
                            continue;
                        }                        
                    }
                    else if (codigo.equals("1") && cantidad <= azucar){
                        azucar -= cantidad;
                        cantidad_azucar += cantidad;
                    }
                    
                    //2 AVENA
                    else if(codigo.equals("2") && cantidad > avena){
                        System.out.println("Solo hay disponible Kg. " + avena + " de acvena, quiere continuar con su compra? SI/NO");
                        continuar = scan.next();
                        
                        while(!(continuar.equalsIgnoreCase("si") || continuar.equalsIgnoreCase("no"))){
                            System.out.println("Favor ingresar SI/NO. No se permiten otro tipo de ingreso.");
                            continuar = scan.next();
                        }
                        if (continuar.equalsIgnoreCase("si")){
                            cantidad = avena;
                            avena = 0;
                            cantidad_avena += cantidad;
                        }
                        else if (continuar.equalsIgnoreCase("no")){
                            cantidad = 0;
                            continue;
                        }                        
                    }
                    else if (codigo.equals("2") && cantidad <= avena){
                        avena -= cantidad;
                        cantidad_avena += cantidad;                        
                    }    
                    
                    //3 TRIGO
                    else if (codigo.equals("3") && cantidad > trigo){
                        System.out.println("Solo hay disponible Kg. " + trigo + " de trigo, quiere continuar con su compra? SI/NO");
                        continuar = scan.next();
                        
                        while(!(continuar.equalsIgnoreCase("si") || continuar.equalsIgnoreCase("no"))){
                            System.out.println("Favor ingresar SI/NO. No se permiten otro tipo de ingreso.");
                            continuar = scan.next();
                        }
                        if (continuar.equalsIgnoreCase("si")){
                            cantidad = trigo;
                            trigo = 0;
                            cantidad_trigo += cantidad;                            
                        }
                        else if (continuar.equalsIgnoreCase("no")){
                            cantidad = 0;
                            continue;
                        }                        
                    }  
                    else if (codigo.equals("3") && cantidad <= trigo){
                        trigo -= cantidad;
                        cantidad_trigo += cantidad;                        
                    }
                     
                    //4 MAIZ
                    else if (codigo.equals("4") && cantidad > maiz){
                        System.out.println("Solo hay disponible Kg. " + maiz + " de maiz, quiere continuar con su compra? SI/NO");
                        continuar = scan.next();
                        
                        while(!(continuar.equalsIgnoreCase("si") || continuar.equalsIgnoreCase("no"))){
                            System.out.println("Favor ingresar SI/NO. No se permiten otro tipo de ingreso.");
                            continuar = scan.next();
                        }
                        if (continuar.equalsIgnoreCase("si")){
                            cantidad = maiz;
                            maiz = 0;
                            cantidad_maiz += cantidad;                            
                        }
                        else if (continuar.equalsIgnoreCase("no")){
                            cantidad = 0;
                            continue;
                        }
                    }
                    else if (codigo.equals("4") && cantidad <= maiz){
                            maiz -= cantidad;
                            cantidad_maiz += cantidad;
                    }
                              
                    //SUBTOTAL Y DESCUENTO 
                    subtotal = precio * cantidad;
                    subtotal_final += subtotal;
                    
                    //DESCUENTO
                    descuento = (subtotal_final > 5000) ? 0.1 : (subtotal_final >= 1000 && subtotal_final <= 5000) ? 0.05 : 0;                
                    
                    //IMPUESTO & DESCUENTO
                    descuento_final = subtotal_final * descuento;
                    impuesto = subtotal_final * 0.07;
                    total = subtotal_final + impuesto - descuento_final;      

                    //AÑADIR
                    if (codigo.equals("1") && producto.equals("Azucar")) {
                        cantidad_1 += cantidad;
                        subtotal_1 = precio * cantidad_1;
                    } else if (codigo.equals("2") && producto.equals("Avena")) {
                        cantidad_2 += cantidad;
                        subtotal_2 = precio * cantidad_2;
                    } else if (codigo.equals("3") && producto.equals("Trigo")) {
                        cantidad_3 += cantidad;
                        subtotal_3 = precio * cantidad_3;
                    } else if (codigo.equals("4") && producto.equals("Maiz")) {
                        cantidad_4 += cantidad;
                        subtotal_4 = precio * cantidad_4;
                    }
                    
                    //PRODUCTO DISPONIBLE NO EXISTE
                    if ((azucar == 0 && avena == 0 && trigo == 0 && maiz == 0 && cliente.equalsIgnoreCase("a")) ||
                        (azucar == 0 && avena == 0 && trigo == 0 && cliente.equalsIgnoreCase("b")) ||
                        (maiz == 0 && cliente.equalsIgnoreCase("c"))) {
                        System.out.println("No hay mas productos.");
                        producto_disponible = false;
                    }                        
                    
                    //CYCLE TO REPEAT      
                    if (producto_disponible) {
                        System.out.println("Desea comprar otro producto? SI/NO.");                 
                        buy = scan.next();

                        while (!buy.equalsIgnoreCase("si") && !buy.equalsIgnoreCase("no")) {
                            System.out.println("ERROR. INGRESO INVALIDO. Tiene que escribir si o no.");
                            buy = scan.next();
                        }

                        if (buy.equalsIgnoreCase("si")) {
                            continue;                        
                        }
                    }
                    
                    if (cantidad_1 > 0) {
                       Factura += "Codigo de Producto: 1\n";
                       Factura += "Producto: Azucar\n";
                       Factura += "Precio por 1 Kg.: Lps. "+ azucar_venta + "\n";
                       Factura += "Cantidad de Kg. : " + cantidad_1 + " Kg.\n";
                       Factura += "Subtotal : Lps." + String.format("%.2f", subtotal_1) + "\n";
                       Factura += "-------------------------------\n";
                   }

                   if (cantidad_2 > 0) {
                       Factura += "Codigo de Producto: 2\n";
                       Factura += "Producto: Avena\n";
                       Factura += "Precio por 1 Kg.: Lps. " + avena_venta + "\n";
                       Factura += "Cantidad de Kg. : " + cantidad_2 + " Kg.\n";
                       Factura += "Subtotal : Lps." + String.format("%.2f", subtotal_2) + "\n";
                       Factura += "-------------------------------\n";
                   }

                   if (cantidad_3 > 0) {
                       Factura += "Codigo de Producto: 3\n";
                       Factura += "Producto: Trigo\n";
                       Factura += "Precio por 1 Kg.: Lps. " + trigo_venta + "\n";
                       Factura += "Cantidad de Kg. : " + cantidad_3 + " Kg.\n";
                       Factura += "Subtotal : Lps." + String.format("%.2f", subtotal_3) + "\n";
                       Factura += "-------------------------------\n";
                   }
                   
                   if (cantidad_4 > 0) {
                       Factura += "Codigo de Producto: 4\n";
                       Factura += "Producto: Maiz\n";
                       Factura += "Precio por 1 Kg.: Lps. " + maiz_venta + "\n";
                       Factura += "Cantidad de Kg. : " + cantidad_4 + " Kg.\n";
                       Factura += "Subtotal : Lps." + String.format("%.2f", subtotal_4) + "\n";
                       Factura += "-------------------------------\n";
                    }       
 
                   //AÑADIR CAJA
                    caja += total;        

                    //FACTURA     
                    if (cantidad_1 > 0 || cantidad_2 > 0 || cantidad_3 > 0 || cantidad_4 > 0){
                    System.out.println("\n   **** FACTURA *****");
                    System.out.println("Tipo de Cliente: " + cliente.toUpperCase());
                    System.out.println(Factura);
                    System.out.println("Subtotal Final: " + String.format("%.2f",subtotal_final));                                        
                    System.out.println("Impuesto 7% : Lps. " + String.format("%.2f",impuesto));
                    System.out.println("Descuento " + descuento * 100 + " % : Lps. " + String.format("%.2f",descuento_final));
                    System.out.println("Total Final: " + String.format("%.2f",total)); 
                    }
                    
                    //REPORTES
                    total_ventas += total;
                    if (cantidad_1 > 0 || cantidad_2 > 0 || cantidad_3 > 0 || cantidad_4 > 0){
                    contador_ventas++;
                    }
                    valor_ventas = total_ventas / contador_ventas;

                    //MAYOR VENTA
                    if (mayorVenta < total) {
                        mayorVenta = total;
                    }else{
                        mayorVenta = mayorVenta;
                    }

                    //PRODUCTO ESTRELLA
                    if (cantidad_maiz > mayor_cantidad) {
                        producto_estrella = "Maiz";
                        mayor_cantidad = cantidad_maiz;
                    }
                    if (cantidad_avena > mayor_cantidad) {
                        producto_estrella = "Avena";
                        mayor_cantidad = cantidad_avena;
                    }
                    if (cantidad_azucar > mayor_cantidad) {
                        producto_estrella = "Azucar";
                        mayor_cantidad = cantidad_azucar;
                    }
                    if (cantidad_trigo > mayor_cantidad) {
                        producto_estrella = "Trigo";
                        mayor_cantidad = cantidad_trigo;
                    }

                    // EMPATE
                    if (cantidad_maiz == mayor_cantidad && !producto_estrella.contains("Maiz")) {
                        producto_estrella += (producto_estrella.equals("") ? "" : ", ") + "Maiz";
                    }
                    if (cantidad_avena == mayor_cantidad && !producto_estrella.contains("Avena")) {
                        producto_estrella += (producto_estrella.equals("") ? "" : ", ") + "Avena";
                    }
                    if (cantidad_azucar == mayor_cantidad && !producto_estrella.contains("Azucar")) {
                        producto_estrella += (producto_estrella.equals("") ? "" : ", ") + "Azucar";
                    }
                    if (cantidad_trigo == mayor_cantidad && !producto_estrella.contains("Trigo")) {
                        producto_estrella += (producto_estrella.equals("") ? "" : ", ") + "Trigo";
                    }

                    // SEGUNDO LUGAR
                    producto_2 = "";
                    cantidad2 = 0;
                    if (!producto_estrella.contains("Maiz") && cantidad_maiz > cantidad2) {
                        producto_2 = "Maiz";
                        cantidad2 = cantidad_maiz;
                    }
                    if (!producto_estrella.contains("Avena") && cantidad_avena > cantidad2) {
                        producto_2 = "Avena";
                        cantidad2 = cantidad_avena;
                    }
                    if (!producto_estrella.contains("Azucar") && cantidad_azucar > cantidad2) {
                        producto_2 = "Azucar";
                        cantidad2 = cantidad_azucar;
                    }
                    if (!producto_estrella.contains("Trigo") && cantidad_trigo > cantidad2) {
                        producto_2 = "Trigo";
                        cantidad2 = cantidad_trigo;
                    }

                    // EMPATE
                    if (!producto_estrella.contains("Maiz") && cantidad_maiz == cantidad2 && !producto_2.contains("Maiz")) {
                        producto_2 += (producto_2.equals("") ? "" : ", ") + "Maiz";
                    }
                    if (!producto_estrella.contains("Avena") && cantidad_avena == cantidad2 && !producto_2.contains("Avena")) {
                        producto_2 += (producto_2.equals("") ? "" : ", ") + "Avena";
                    }
                    if (!producto_estrella.contains("Azucar") && cantidad_azucar == cantidad2 && !producto_2.contains("Azucar")) {
                        producto_2 += (producto_2.equals("") ? "" : ", ") + "Azucar";
                    }
                    if (!producto_estrella.contains("Trigo") && cantidad_trigo == cantidad2 && !producto_2.contains("Trigo")) {
                        producto_2 += (producto_2.equals("") ? "" : ", ") + "Trigo";
                    }

                    // TERCER LUGAR
                    producto_3 = "";
                    cantidad3 = 0; 
                    if (!producto_estrella.contains("Maiz") && !producto_2.contains("Maiz") && cantidad_maiz > cantidad3) {
                        producto_3 = "Maiz";
                        cantidad3 = cantidad_maiz;
                    }
                    if (!producto_estrella.contains("Avena") && !producto_2.contains("Avena") && cantidad_avena > cantidad3) {
                        producto_3 = "Avena";
                        cantidad3 = cantidad_avena;
                    }
                    if (!producto_estrella.contains("Azucar") && !producto_2.contains("Azucar") && cantidad_azucar > cantidad3) {
                        producto_3 = "Azucar";
                        cantidad3 = cantidad_azucar;
                    }
                    if (!producto_estrella.contains("Trigo") && !producto_2.contains("Trigo") && cantidad_trigo > cantidad3) {
                        producto_3 = "Trigo";
                        cantidad3 = cantidad_trigo;
                    }

                    // EMPATE
                    if (!producto_estrella.contains("Maiz") && !producto_2.contains("Maiz") && cantidad_maiz == cantidad3 && !producto_3.contains("Maiz")) {
                        producto_3 += (producto_3.equals("") ? "" : ", ") + "Maiz";
                    }
                    if (!producto_estrella.contains("Avena") && !producto_2.contains("Avena") && cantidad_avena == cantidad3 && !producto_3.contains("Avena")) {
                        producto_3 += (producto_3.equals("") ? "" : ", ") + "Avena";
                    }
                    if (!producto_estrella.contains("Azucar") && !producto_2.contains("Azucar") && cantidad_azucar == cantidad3 && !producto_3.contains("Azucar")) {
                        producto_3 += (producto_3.equals("") ? "" : ", ") + "Azucar";
                    }
                    if (!producto_estrella.contains("Trigo") && !producto_2.contains("Trigo") && cantidad_trigo == cantidad3 && !producto_3.contains("Trigo")) {
                        producto_3 += (producto_3.equals("") ? "" : ", ") + "Trigo";
                    }

                    // CUARTO LUGAR
                    producto_4 = ""; 
                    cantidad4 = 0;
                    if (!producto_estrella.contains("Maiz") && !producto_2.contains("Maiz") && !producto_3.contains("Maiz") && cantidad_maiz > cantidad4) {
                        producto_4 = "Maiz";
                        cantidad4 = cantidad_maiz;
                    }
                    if (!producto_estrella.contains("Avena") && !producto_2.contains("Avena") && !producto_3.contains("Avena") && cantidad_avena > cantidad4) {
                        producto_4 = "Avena";
                        cantidad4 = cantidad_avena;
                    }
                    if (!producto_estrella.contains("Azucar") && !producto_2.contains("Azucar") && !producto_3.contains("Azucar") && cantidad_azucar > cantidad4) {
                        producto_4 = "Azucar";
                        cantidad4 = cantidad_azucar;
                    }
                    if (!producto_estrella.contains("Trigo") && !producto_2.contains("Trigo") && !producto_3.contains("Trigo") && cantidad_trigo > cantidad4) {
                        producto_4 = "Trigo";
                        cantidad4 = cantidad_trigo;
                    }

                    // EMPATE
                    if (!producto_estrella.contains("Maiz") && !producto_2.contains("Maiz") && !producto_3.contains("Maiz") && cantidad_maiz == cantidad4 && !producto_4.contains("Maiz")) {
                        producto_4 += (producto_4.equals("") ? "" : ", ") + "Maiz";
                    }
                    if (!producto_estrella.contains("Avena") && !producto_2.contains("Avena") && !producto_3.contains("Avena") && cantidad_avena == cantidad4 && !producto_4.contains("Avena")) {
                        producto_4 += (producto_4.equals("") ? "" : ", ") + "Avena";
                    }
                    if (!producto_estrella.contains("Azucar") && !producto_2.contains("Azucar") && !producto_3.contains("Azucar") && cantidad_azucar == cantidad4 && !producto_4.contains("Azucar")) {
                        producto_4 += (producto_4.equals("") ? "" : ", ") + "Azucar";
                    }
                    if (!producto_estrella.contains("Trigo") && !producto_2.contains("Trigo") && !producto_3.contains("Trigo") && cantidad_trigo == cantidad4 && !producto_4.contains("Trigo")) {
                        producto_4 += (producto_4.equals("") ? "" : ", ") + "Trigo";
                    }

                    
                    //RESETEAR VARIABLES
                    Factura = "";                    
                    subtotal_final = 0;
                    impuesto = 0;
                    descuento = 0;
                    descuento_final = 0;
                    total = 0;

                    if (!producto_disponible || buy.equalsIgnoreCase("no")) {
                        break;
                    }
                }
        }
       
        // ** VENTANA DE COMPRAS **
        if (ventana.equalsIgnoreCase("c")){
            if (caja_abierta == false){
                System.out.println("\nAun no ha abierto la Caja.");
                continue;
            }            
            System.out.println("\n|---------------------------------------------------");
            System.out.println("|    Proveedor        |      Producto(s) que vende   |");
            System.out.println("|-----------------------------------------------------");
            System.out.println("|   Proveedor A       |   Azucar, Maiz               |");
            System.out.println("|   Proveedor B       |   Avena, Trigo               |");
            System.out.println("|   Proveedor C       |   Avena                      |");
            System.out.println("|-----------------------------------------------------");            
            System.out.println("\nFavor ingresar el tipo de Proveedor ( A, B, C ).");
            System.out.println("Escribir 'e' para volver al menu principal.");            
            String proveedor = scan.next();
            
            //RESTRICCIÓN
            while (!(proveedor.equalsIgnoreCase("a") || proveedor.equalsIgnoreCase("b") 
                    || proveedor.equalsIgnoreCase("c") || proveedor.equalsIgnoreCase("e"))) {
                    System.out.println("ERROR. Debe de ingresar (A, B, C). Intente de nuevo");
                    proveedor = scan.next();
                 }             
            
            //SALIR
            if (proveedor.equalsIgnoreCase("e")){
                continue;
            }

            // --- PROVEEDOR A ---
            if (proveedor.equalsIgnoreCase("a")){
                    System.out.println("\n|------------------------------------------------");
                    System.out.println("|  Codigo     |  Producto  |  Precio por 1 kg   |");
                    System.out.println("|-----------------------------------------------");
                    System.out.println("|   1         |   Azucar   |     Lps. 25        |");
                    System.out.println("|   4         |   Maiz     |     Lps. 18        |");
                    System.out.println("|------------------------------------------------");
            }
            // --- PROVEEDOR B ----
            else if (proveedor.equalsIgnoreCase("b")){
                    System.out.println("\n|------------------------------------------------");
                    System.out.println("|  Codigo     |  Producto  |  Precio por 1 kg   |");
                    System.out.println("|-----------------------------------------------");
                    System.out.println("|   2         |   Avena    |     Lps. 20        |");
                    System.out.println("|   3         |   Trigo    |     Lps. 30        |");
                    System.out.println("|------------------------------------------------");            
            }
            // --- PROVEEDOR C ---
            else if (proveedor.equalsIgnoreCase("c")){
                    System.out.println("\n|------------------------------------------------");
                    System.out.println("|  Codigo     |  Producto  |  Precio por 1 kg   |");
                    System.out.println("|-----------------------------------------------");
                    System.out.println("|   2         |   Avena    |     Lps. 22        |");
                    System.out.println("|------------------------------------------------");                
            }
            //INPUT
            System.out.println("Favor ingrear el numero del codigo del producto que desea comprar.");
            System.out.println("Escribir 'e' para volver al menu principal.");
            codigo = scan.next();                  
                    
                    //RESTRICCIÓN
                    while (true) {
                        if (proveedor.equalsIgnoreCase("a")){
                            
                            //RESTRICCIÓN A
                            if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3") 
                                || codigo.equals("4") || codigo.equalsIgnoreCase("e")) {
                                if (codigo.equals("2") || codigo.equals("3")) {
                                    System.out.println("Este producto no lo vende el proveedor A. Intente de nuevo.");
                                } else {
                                break;
                                    }
                                } else {
                                System.out.println("ERROR. Este codigo no existe unico codigo validos son (1,4), intente de nuevo.");
                                }
                            codigo = scan.next();
                            }
                        //RESTRICCIÓN B
                        else if (proveedor.equalsIgnoreCase("b")){
                            if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3") 
                                || codigo.equals("4") || codigo.equalsIgnoreCase("e")) {
                                if (codigo.equals("1") || codigo.equals("4")) {
                                    System.out.println("Este producto no lo vende el proveedor B. Intente de nuevo.");
                                } else {
                                break;
                                    }
                                } else {
                                System.out.println("ERROR. Este codigo no existe unico codigo validos son (2,3), intente de nuevo.");
                                }
                            codigo = scan.next();                        
                        }
                        //RESTRICCIÓN C
                        else if (proveedor.equalsIgnoreCase("c")){
                            if (codigo.equals("1") || codigo.equals("2") || codigo.equals("3") 
                                || codigo.equals("4") || codigo.equalsIgnoreCase("e")) {
                                if (codigo.equals("1") || codigo.equals("3") || codigo.equals("4")) {
                                    System.out.println("Este producto no lo vende el proveedor C. Intente de nuevo.");
                                } else {
                                break;
                                    }
                                } else {
                                System.out.println("ERROR. Este codigo no existe unico codigo valido es (2), intente de nuevo.");
                                }
                            codigo = scan.next();                            
                        }
                    }
                    
                    //SALIDA
                    if (codigo.equalsIgnoreCase("e")) {
                        continue;
                        }                        

                    // TIPO DE PRODUCTO A COMPRAR
                    if (codigo.equals("1")){
                        producto = "Azucar";
                        precio = azucar_compra;
                    }
                    else if (codigo.equalsIgnoreCase("2") && proveedor.equalsIgnoreCase("b")){
                        producto = "Avena";
                        precio = avena_compra_B;
                    }
                    else if (codigo.equalsIgnoreCase("2") && proveedor.equalsIgnoreCase("c")){
                        producto = "Avena";
                        precio = avena_compra_C;
                    }
                    else if (codigo.equalsIgnoreCase("3")){
                        producto = "Trigo";
                        precio = trigo_compra;
                    }
                    else if (codigo.equals("4")){
                        producto = "Maiz";
                        precio = maiz_compra;
                    }
                    
                    //CANTIDAD A COMPRAR
                    System.out.println("Cuantos kgs va a comprar?");
                    valid = false;
                    
                    while (!valid){
                        try{
                            cantidad = scan.nextInt();
                            valid = true;
                        }catch (InputMismatchException e){
                            System.out.println("Debe de Ingresar un numero. Intente de nuevo");
                            scan.next();
                        }
                    }

                    while ( cantidad < 0){
                        System.out.println("No se permiten numeros negativos.");
                        valid = false;
                        while (!valid){                   
                            try{
                            cantidad = scan.nextInt();
                                valid = true;
                            }catch (InputMismatchException e){
                                System.out.println("Debe de Ingresar un numero. Intente de nuevo");
                                scan.next();
                            }
                        }
                    }             
                    
                    //NO SE IMPRIME FACTURA
                    if (cantidad == 0){
                        System.out.println("Cantidad es 0, no se realizo ninguna compra.");
                        continue;
                    }
                    
                    //TOTAL
                    total = precio*cantidad;                    

                    //NO SE PUEDE PAGAR COMPRA
                    if (total > caja){
                        System.out.println("No se puede realizar compra.");
                        System.out.println("Solo tiene en caja Lps. " + caja);
                        System.out.println("Se requiere Lps. " + total);
                        continue;
                    }                    
                    
                    //PRODUCTO AÑADIR
                    if (codigo.equals("1")){
                        azucar += cantidad;
                    }
                    else if (codigo.equals("2")){
                        avena += cantidad;
                    }
                    else if (codigo.equals("3")){
                        trigo += cantidad;
                    }
                    else if (codigo.equals("4")){
                        maiz += cantidad;
                    }

                    //QUITAR A CAJA
                    caja -= total;

                    //FACTURA
                    System.out.println("   **** FACTURA ****");
                    System.out.println("Tipo de Proveedor: " + proveedor.toUpperCase());
                    System.out.println("Codigo de Producto: " + codigo);
                    System.out.println("Producto: " + producto);
                    System.out.println("Cantidad por Kg: " + cantidad + " kg.");
                    System.out.println("Precio por 1 Kg. : Lps." + precio);
                    System.out.println("Total : Lps." + total);
                    
                    //REPORTES
                    total_compras += total;
                    contador_compras ++;
                    valor_compra = total_compras/contador_compras;
                    
                    //COMPRA MAYOR
                    if (mayorCompra > total){
                        mayorCompra = mayorCompra;
                    }else{
                        mayorCompra = total;
                    }                    
                }
        
        // ** VENTANA DE REPORTES **
        if (ventana.equalsIgnoreCase("d")){
            if (caja_abierta == false){
                System.out.println("\nNo ha abierto caja.");
                continue;
            }
            
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("|                  ******* REPORTES ********                    |" );
            System.out.println("-----------------------------------------------------------------");
            System.out.println("A.- Cantidad Actual en Caja: Lps. " + String.format("%.2f",caja));
            System.out.println("-----------------------------------------------------------------");
            System.out.println("B.- Numero de Compras y Ventas realizadas en el dia: ");
            System.out.println("    Ventas Realizadas en el dia: " + contador_ventas);
            System.out.println("    Compras Realizadas en el dia: " + contador_compras);
            System.out.println("----------------------------------------------------------------");
            System.out.println("C.- Volumen total de Compras y Ventas efectuadas antes del cierre. "
                                + "\nMostrando el margen de ganancia obtenido tambien");
            System.out.println("    Total Ventas: Lps. " + String.format("%.2f" , total_ventas));
            System.out.println("    Total Compras: Lps. " + String.format("%.2f" ,total_compras));
            System.out.println("-----------------------------------------------------------------");
            System.out.println("D.- Valor Medio de Compra y Venta: ");
            System.out.println("    Valor de Compra: " + String.format("%.2f", valor_compra) + " %");
            System.out.println("    Valor de Venta: " + String.format("%.2f", valor_ventas) + " %");
            System.out.println("----------------------------------------------------------------");
            System.out.println("E.- La venta con la mayor ganancia realizada y"
                                + "\nla compra con mas gasto efectuada: ");
            System.out.println("    La venta con mayor ganancia: Lps." + String.format("%.2f" , mayorVenta));
            System.out.println("    La compra con mas gasto efectuada: Lps." + String.format("%.2f" ,mayorCompra ));            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("F.- Producto(s) Estrella: " + producto_estrella + ", Cantidad vendida: " + mayor_cantidad + " kgs.");
            System.out.println("------------------------------------------------------------------");
            System.out.println("G.- Ranking:");
            System.out.println("    1.- " + producto_estrella + ", Cantidad: Kg." + mayor_cantidad
                            + "\n    2.- " + producto_2 + ", Cantidad: Kg." + cantidad2
                            + "\n    3.- " + producto_3 + ", Cantidad: Kg." + cantidad3
                            + "\n    4.- " + producto_4 + ", Cantidad: Kg." + cantidad4); 
        }
        
        // ** VENTANA DE CIERRER DE CAJA **
        if (ventana.equalsIgnoreCase("e")){
            if (caja_abierta == false){
                System.out.println("No se ha abierto caja.");
                continue;
            }            
            
            System.out.println("\nTotal de Ganancia en la Caja: Lps. " + caja);            
            System.out.println("Desea Cerrar la Caja? SI/NO");
            si_no = scan.next();
            
            while(!(si_no.equalsIgnoreCase("si") || si_no.equalsIgnoreCase("no"))){
                System.out.println("Ingreso invalido. Deber ser si/no. Intente de nuevo.");
                si_no = scan.next();
            }
            
            if (si_no.equalsIgnoreCase("si")){ 
                caja_abierta = false;
                
                //CONTADORES RESETEO
                contador_ventas = 0;
                contador_compras = 0;
                
                //DEPOSITO
                System.out.println("\nCuanto dinero desea depositar al banco? "
                        + "\nTenga en cuenta la cantidad maxima que puede depositar el el 60% en efectivo en caja.");
                valid = false;
                
                while (!valid){
                    try{
                        deposito = scan.nextInt();
                        valid = true;
                    }catch(InputMismatchException e){
                        System.out.println("Debe de ingresar un numero. Intente de nuevo.");
                        scan.next();
                    }
                }
                
                while (deposito < 0){
                    System.out.println("No se permite el ingreso de numeros negativos. Intente de nuevo.");
                    deposito = scan.nextInt();
                }
                
                deposito_posible = caja * 0.6;
                while (deposito > deposito_posible){
                    System.out.println("Solo puede depositar el menos o igual que el 60% de efectivo de caja. Intente de nuevo.");
                    deposito = scan.nextInt();
                }
                caja -= deposito;
                
            }
            else if (si_no.equalsIgnoreCase("no")){
                continue;
            }
        }

        // ** SALIR DEL SISTEMA **
        if (ventana.equalsIgnoreCase("f")){
            System.out.println("\nSaliendo del Sistema.....");
            System.exit(0);
            }
        }    
    }
}