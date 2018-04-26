package br.com.itau.restbd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.restbd.entidade.Cliente;
import br.com.itau.restbd.servico.ClienteService;

/**
 * Controller do servico Clientes com as opcoes de criar|listarTodos|obterPorId|atualizar|deletar
 * @author Leonardo Oliveira
 *
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/clientes")
public class ClienteController {
	
	//Servico do cliente auto injetavel pelo spring
	@Autowired
	private ClienteService servicoCliente;
	
	/**
	 * Cria um novo cliente recebendo como parametro um Cliente no formato json
	 * @param cliente
	 * @return Cliente
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Cliente criar(@Valid @RequestBody Cliente cliente) {
		return servicoCliente.criarOuAtualizar(cliente);
	}
	
	/**
	 * Lista todos os clientes da base com opcao de paginacao direto na URI
	 * @return List<Cliente>
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> listarTodos() {
		return servicoCliente.listar();
	}
	
	/**
	 * Retorna o cliente de acordo com o id informado
	 * @param id
	 * @return Cliente
	 */
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Cliente obterPorId(@PathVariable(value = "id") Long id) {
		return servicoCliente.obterPorId(id);
	}
	
	/**
	 * Atualiza o cliente passado via json com os novos dados
	 * @param cliente
	 * @return Cliente
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public Cliente atualizar(@Valid @RequestBody Cliente cliente) {
		return servicoCliente.criarOuAtualizar(cliente);
	}
	
	/**
	 * Remove um cliente do banco de dados em caso de sucesso retorna 200 e nao encontrado 404
	 * @param id
	 * @return 200OK
	 */
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
		
		servicoCliente.deletar(id);

	    return ResponseEntity.ok().build();
	}
	
}