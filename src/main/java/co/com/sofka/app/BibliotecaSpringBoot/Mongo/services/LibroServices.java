package co.com.sofka.app.BibliotecaSpringBoot.Mongo.services;

import co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto.LibroDto;
import co.com.sofka.app.BibliotecaSpringBoot.Mongo.repositories.ILibrosRepositories;
import co.com.sofka.app.BibliotecaSpringBoot.Mongo.services.impl.LibroServicesI;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroServices implements LibroServicesI {

    @Autowired
    private ILibrosRepositories iLibrosRepositories;

    @Override
    public Optional<LibroDto> consultarLibroDtoPorID(String id) {
        return iLibrosRepositories.findById(id);
    }

    @Override
    public List<LibroDto> mostrarTodos() {
        return iLibrosRepositories.findAll();
    }

    @Override
    public Optional<LibroDto> getById(String id) {
        return iLibrosRepositories.findById(id);
    }

    @Override
    public LibroDto agregarLibroDto(LibroDto libroDto) {
        return iLibrosRepositories.save(libroDto);
    }

    @Override
    public boolean eliminarLibroDtoPorID(String id) {
        return getById(id).map(libroDto -> {
            iLibrosRepositories.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public LibroDto actualizarLibroDto(LibroDto libroDto) {
        Optional<LibroDto> libro = iLibrosRepositories.findById(libroDto.getId());
        if(libro.isPresent()){

            libro.get().setId(libroDto.getId());
            libro.get().setNombre(libroDto.getNombre() );
            libro.get().setFechaPrestado(libroDto.getFechaPrestado());
            libro.get().setCantidadDisponible(libroDto.getCantidadDisponible());
            libro.get().setCantidadPrestada(libroDto.getCantidadPrestada());
            libro.get().setTipo(libroDto.getTipo());
            libro.get().setCategoria(libroDto.getCategoria());

            return iLibrosRepositories.save(libro.get());
        }
        throw new RuntimeException("El Libro indicado no existe");
    }

    @Override
    public boolean verificarDisponibleLibroDto(LibroDto libroDto) {
        return libroDto.getCantidadDisponible()>libroDto.getCantidadPrestada();
    }

    @Override
    public List<LibroDto> recomendarPorCategoria(String categoria) {
        List<LibroDto> libros = new ArrayList<>();
        iLibrosRepositories.findBycategoria(categoria).forEach(l ->{
            libros.add(l);
        });
        return libros;
    }

    @Override
    public List<LibroDto> recomendarPorTipo(String tipo) {
        List<LibroDto> libros = new ArrayList<>();
        iLibrosRepositories.findBytipo(tipo).forEach(l -> {
            libros.add(l);
        });
        return libros;
    }

    @Override
    public String libroDtoPrestado(String id) {
        return getById(id).map(l -> {
            if(verificarDisponibleLibroDto(l)){
                l.setCantidadPrestada(l.getCantidadPrestada()+1);
                l.setFechaPrestado(LocalDate.now());

                LibroDto libroActualizado = l;
                iLibrosRepositories.save(libroActualizado);

                return "Libro prestado exitosamente";
            }
            return "El libro no disponible en el actualmente";
        }).orElseThrow(()->new RuntimeException("El libro no existe"));

    }

    @Override
    public String libroDtoRegresado(String id) {
        return getById(id).map(l -> {
            if(l.getCantidadPrestada()>0){
                l.setCantidadPrestada(l.getCantidadPrestada()-1);

                LibroDto libroActualizado = l;
                iLibrosRepositories.save(libroActualizado);
                return "Libro devuelto exitosamente";
            }
            return "Devolucion no exitosa";
        }).orElseThrow(()-> new RuntimeException("El libro no existe"));
    }
}
