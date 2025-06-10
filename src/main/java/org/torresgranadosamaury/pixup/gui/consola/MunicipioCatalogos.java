package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.model.Estado;
import org.torresgranadosamaury.pixup.model.Municipio;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.File;

public class MunicipioCatalogos extends Catalogos<Municipio>{


    public static MunicipioCatalogos municipioCatalogo;
    private MunicipioCatalogos( )
    {
        super();
    }

    public static MunicipioCatalogos getInstance( )
    {
        if(municipioCatalogo==null)
        {
            municipioCatalogo = new MunicipioCatalogos();
        }
        return municipioCatalogo;
    }

    @Override
    public Municipio newT()
    {
        return new Municipio( );
    }

    @Override
    public boolean processNewT(Municipio municipio)
    {
        System.out.println("Teclee un municipio" );
        municipio.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Municipio municipio)
    {
        System.out.println("Id del Municipio " + municipio.getId( ) );
        System.out.println("Municipio a editar: " + municipio.getNombre( ) );
        System.out.println("Teclee el valor nuevo del municipio" );
        municipio.setNombre( ReadUtil.read( ) );
    }

    @Override
    public File getFile() {
        return new File("Municipio.list");
    }

    @Override
    public String getTitulo() {
        return "Municipios";
    }

}
