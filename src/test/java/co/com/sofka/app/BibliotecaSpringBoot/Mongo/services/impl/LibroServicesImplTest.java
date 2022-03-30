package co.com.sofka.app.BibliotecaSpringBoot.Mongo.services.impl;

import co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto.LibroDto;
import co.com.sofka.app.BibliotecaSpringBoot.Mongo.repositories.ILibrosRepositories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibroServicesImplTest {

    private List<LibroDto> libros() {

        LibroDto libroUno = new LibroDto();
        libroUno.setId("1");
        libroUno.setNombre("Harry Potter Y la Piedra Filosofal");
        libroUno.setTipo("Literatura");
        libroUno.setCategoria("Fantasia");
        libroUno.setFechaPrestado(LocalDate.parse("2020-10-01"));
        libroUno.setCantidadDisponible(3);
        libroUno.setCantidadPrestada(4);

        LibroDto libroDos = new LibroDto();
        libroDos.setId("2");
        libroDos.setNombre("El Señor de los Anillos");
        libroDos.setTipo("Literatura");
        libroDos.setCategoria("Fantasia");
        libroDos.setFechaPrestado(LocalDate.parse("2020-07-23"));
        libroDos.setCantidadDisponible(2);
        libroDos.setCantidadPrestada(5);

        LibroDto libroTres = new LibroDto();
        libroTres.setId("3");
        libroTres.setNombre("Semana");
        libroTres.setTipo("Revista");
        libroTres.setCategoria("Farandula");
        libroTres.setFechaPrestado(LocalDate.parse("2020-11-10"));
        libroTres.setCantidadDisponible(5);
        libroTres.setCantidadPrestada(1);

        LibroDto libroCuatro = new LibroDto();
        libroCuatro.setId("4");
        libroCuatro.setNombre("Harry Potter Y la Camara de los Secretos");
        libroCuatro.setTipo("Literatura");
        libroCuatro.setCategoria("Fantasia");
        libroCuatro.setFechaPrestado(LocalDate.parse("2020-10-11"));
        libroCuatro.setCantidadDisponible(5);
        libroCuatro.setCantidadPrestada(2);

    return libros();
    }

    @MockBean
    private ILibrosRepositories librosRepositories;

    @Autowired
    private LibroServicesImpl libroServices;

    @Test
    void consultarLibroDtoPorID() {
    }

    @Test
    void mostrarTodos() {
    }

    @Test
    void getById() {
    }

    @Test
    @DisplayName("Prueba para agregar libro")
    void agregarLibroDto() {
        LibroDto libroCinco = new LibroDto();
        libroCinco.setId("5");
        libroCinco.setNombre("Harry Potter el Prisionero de Azkaban");
        libroCinco.setTipo("Literatura");
        libroCinco.setCategoria("Fantasia");
        libroCinco.setFechaPrestado(LocalDate.parse("2020-12-11"));
        libroCinco.setCantidadDisponible(1);
        libroCinco.setCantidadPrestada(4);

        //Mockito.when(librosRepositories.save(any())).thenReturn(libroCinco);
    }

    @Test
    void eliminarLibroDtoPorID() {
    }

    @Test
    void actualizarLibroDto() {
    }

    @Test
    void verificarDisponibleLibroDto() {
    }

    @Test
    void recomendarPorCategoria() {
    }

    @Test
    void recomendarPorTipo() {
    }

    @Test
    void libroDtoPrestado() {
    }

    @Test
    void libroDtoRegresado() {
    }
}