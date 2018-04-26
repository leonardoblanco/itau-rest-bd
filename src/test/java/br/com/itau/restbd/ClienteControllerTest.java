package br.com.itau.restbd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.itau.restbd.controller.ClienteController;
import br.com.itau.restbd.entidade.Cliente;
import br.com.itau.restbd.servico.ClienteService;
/**
 * Classe para teste do controller de cliente apenas para o verbo GET e o Servico
 * @author loliveira
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService clienteService;
	
	Cliente mockCliente = new Cliente(1L, "Leonardo", "11965203014", "leoloko@gmail.com");

	String exampleClienteJson = "{\n" + 
			"    \"id\": 1,\n" + 
			"    \"nome\": \"LeoLoko\",\n" + 
			"    \"telefone\": \"11965203014\",\n" + 
			"    \"email\": \"leoloko@gmail.com\"\n" + 
			"}";
	
	@Test
	public void obterClienteServicoAPI() throws Exception {

		Mockito.when(clienteService.obterPorId(Mockito.eq(1L))).thenReturn(mockCliente);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected = "{\"id\": 1,\"nome\": \"Leonardo\",\"telefone\": \"11965203014\",\"email\": \"leoloko@gmail.com\"}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
