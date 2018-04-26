package br.com.itau.restbd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.restbd.entidade.Cliente;
/**
 * Interface de definicao do repositorio de cliente
 * Como trata-se de um CRUD simples nao ha nenhum metodo especifico
 * Caso haja metodos ou consultas especificas, devem ser declaradas nessa interface
 * @author Leonardo Oliveira
 *
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}