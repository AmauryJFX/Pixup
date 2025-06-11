package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.gui.LecturaAccion;
import org.torresgranadosamaury.pixup.model.Catalogo;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Catalogos<T extends Catalogo> extends LecturaAccion
{
    protected List<T>list;
    protected T t;
    protected boolean flag2;

    public Catalogos()
    {
        list = new ArrayList<>( );
    }

    public boolean isListEmpty()
    {
        return list.isEmpty();
    }

    public void print( )
    {
        if( isListEmpty( ) )
        {
            System.out.println( "No hay elementos");
        }
        list.stream().forEach( System.out::println );
    }

    public abstract T newT( );
    public abstract boolean processNewT( T t );
    public abstract void processEditT( T t );

    public void add( )
    {
        t = newT( );
        if( processNewT( t ) )
        {
            t.setId( list.size( ) + 1 );
            list.add( t );
        }
    }

    public void edit() {
        if (isListEmpty()) {
            System.out.println("No hay elementos");
            return;
        }

        print();
        System.out.println("Ingrese el ID del elemento a editar:");
        int id = ReadUtil.readInt();

        t = list.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);

        if (t == null) {
            System.out.println("ID incorrecto. No se encontró el elemento.");
        } else {
            processEditT(t);
            System.out.println("Elemento modificado");
        }
    }


    public void remove() {
        if (isListEmpty()) {
            System.out.println("No hay elementos");
            return;
        }

        print();
        System.out.println("Ingrese el ID del elemento a borrar:");
        int id = ReadUtil.readInt();

        t = list.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);

        if (t == null) {
            System.out.println("ID incorrecto. No se encontró el elemento.");
        } else {
            list.remove(t);
            System.out.println("Elemento borrado");
        }
    }

    @Override
    public void procesaOpcion()
    {
        switch (opcion)
        {
            case 1:
                add( );
                break;
            case 2:
                edit( );
                break;
            case 3:
                remove( );
                break;
            case 4:
                print( );
                break;
            case 5:
                guardarArchivo( );
                break;
            case 6:
                leerArchivo( );
                break;
        }
    }

    public abstract File getFile( );

    private void leerArchivo()
    {
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;


        try
        {
            file = getFile( );
            fileInputStream = new FileInputStream( file );
            objectInputStream = new ObjectInputStream( fileInputStream );
            list = (List<T>) objectInputStream.readObject( );
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println( "Leer archivo");
    }

    private void guardarArchivo()
    {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            if( isListEmpty() )
            {
                System.out.println( "Lista vacia");
                return;
            }
            file = getFile( );
            fileOutputStream = new FileOutputStream( file );
            objectOutputStream = new ObjectOutputStream( fileOutputStream );
            objectOutputStream.writeObject( list );
            objectOutputStream.close( );
            fileOutputStream.close( );
            System.out.println( "Archivo Guardado");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }


    }

    public abstract String getTitulo( );

    @Override
    public void despliegaMenu()
    {
        System.out.println("Menú de " + getTitulo( ) + ":");
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Agregar");
        System.out.println("2.-Editar");
        System.out.println("3.-Borrar");
        System.out.println("4.-Imprimir");
        System.out.println("7.-Salir");
    }

    @Override
    public int valorMinMenu( )
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 7;
    }
    public List<T> getList() {
        return list;
    }

    public void menu() {
        int op;
        do {
            despliegaMenu();
            op = ReadUtil.readInt();
            if (op >= valorMinMenu() && op <= valorMaxMenu()) {
                opcion = op;
                procesaOpcion();
            } else {
                System.out.println("Opción fuera de rango");
            }
        } while (op != valorMaxMenu());
    }

}