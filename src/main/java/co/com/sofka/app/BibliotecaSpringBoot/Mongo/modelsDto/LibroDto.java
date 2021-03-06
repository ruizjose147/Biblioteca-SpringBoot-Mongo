package co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "libros")
public class LibroDto {

    @Id
    private String id;
    private String nombre;
    private String categoria;
    private String tipo;
    private LocalDate fechaPrestado;
    private Integer cantidadDisponible;
    private Integer cantidadPrestada;

    public LibroDto() {
    }

    public LibroDto(String id, String nombre, String categoria, String tipo, LocalDate fechaPrestado, Integer cantidadDisponible, Integer cantidadPrestada) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.fechaPrestado = fechaPrestado;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadPrestada = cantidadPrestada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaPrestado() {
        return fechaPrestado;
    }

    public void setFechaPrestado(LocalDate fechaPrestado) {
        this.fechaPrestado = fechaPrestado;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getCantidadPrestada() {
        return cantidadPrestada;
    }

    public void setCantidadPrestada(Integer cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroDto libroDto = (LibroDto) o;
        return Objects.equals(id, libroDto.id) && Objects.equals(nombre, libroDto.nombre) && Objects.equals(categoria, libroDto.categoria) && Objects.equals(tipo, libroDto.tipo) && Objects.equals(fechaPrestado, libroDto.fechaPrestado) && Objects.equals(cantidadDisponible, libroDto.cantidadDisponible) && Objects.equals(cantidadPrestada, libroDto.cantidadPrestada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, categoria, tipo, fechaPrestado, cantidadDisponible, cantidadPrestada);
    }
}
