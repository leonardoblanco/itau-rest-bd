package br.com.itau.restbd.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.restbd.entidade.Cliente;
import br.com.itau.restbd.exception.ResourceNotFoundException;
import br.com.itau.restbd.repositorio.ClienteRepositorio;

/**
 * Camada de servico para realizar o intermedio do controller com o repositorio de banco de dados
 * Para um cenario simples como o solicitado, esta camada nao se fazia necessaria. Foi feita pois era um requisito.
 * @author Leonardo Oliveira
 *
 */
@Service
public class ClienteService {

	//Repositorio do cliente auto injetavel pelo spring
	@Autowired
	private ClienteRepositorio repositorioCliente;
	
	/**
	 * Cria ou atualiza cliente pois o metodo eh sempre save
	 * @param cliente
	 * @return
	 */
	public Cliente criarOuAtualizar(Cliente cliente) {
		return repositorioCliente.save(cliente);
	}
	
	/**
	 * Lista todos os clientes ordenados por nome utilizando lambda expression
	 * @return
	 */
	public List<Cliente> listar(){
		List<Cliente> clientes = repositorioCliente.findAll();
		clientes.sort((c1, c2)->c1.getNome().compareTo(c2.getNome()));
		return clientes;
	}
	
	/**
	 * Obtem um cliente pelo id
	 * @param id
	 * @return
	 */
	public Cliente obterPorId(Long id) {
		return repositorioCliente.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
	}
	
	/**
	 * Apaga um cliente pelo id
	 * @param id
	 */
	public void deletar(Long id) {
		Cliente c = repositorioCliente.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

	    repositorioCliente.delete(c);
	}
	
}
