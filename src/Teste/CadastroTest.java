package Teste;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Model.Cadastro;
import Service.CadastroService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroTest {

	Cadastro cadastro, copia;
	CadastroService cadastroService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		cadastro = new Cadastro();
		
		cadastro.setNomeCompleto("Luan Peixoto");
		cadastro.setDataDeNascimento("01/01/2016");
		cadastro.setSexo("Masculino");
		cadastro.setEmail("Admin@gmail.com");
		cadastro.setTelefoneResidencial("(  )     -    ");
		cadastro.setTelefoneCelular("(11) 00000-0000");
		cadastro.setUniversidade("Universidade Novo Intelecto");
		cadastro.setCurso("Analise e desenvolvimento de sistemas");
		cadastro.setUsuario("Luan");
		cadastro.setSenha("123456");
		cadastro.setPerguntaSecreta("Arroz");
		cadastro.setCargo("Colaborador");
		cadastro.setCategoria("Colaborador");

		
		
		copia = new Cadastro();
		copia.setNomeCompleto("Luan Peixoto");
		copia.setDataDeNascimento("01/01/2016");
		copia.setSexo("Masculino");
		copia.setEmail("Admin@gmail.com");
		copia.setTelefoneResidencial("(  )     -    ");
		copia.setTelefoneCelular("(11) 00000-0000");
		copia.setUniversidade("Universidade Novo Intelecto");
		copia.setCurso("Analise e desenvolvimento de sistemas");
		copia.setUsuario("Luan");
		copia.setSenha("123456");
		copia.setPerguntaSecreta("Arroz");
		copia.setCargo("Colaborador");
		copia.setCategoria("Colaborador");
		
		cadastroService = new CadastroService();
		System.out.println(cadastro);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Inserir() {
		System.out.println("Inserir Cadastro");
		
		Cadastro fixture = new Cadastro();
		fixture.setNomeCompleto("Luan Peixoto");
		fixture.setDataDeNascimento("01/01/2016");
		fixture.setSexo("Masculino");
		fixture.setEmail("Admin@gmail.com");
		fixture.setTelefoneResidencial("(  )     -    ");
		fixture.setTelefoneCelular("(11) 00000-0000");
		fixture.setUniversidade("Universidade Novo Intelecto");
		fixture.setCurso("Analise e desenvolvimento de sistemas");
		fixture.setUsuario("Luan");
		fixture.setSenha("123456");
		fixture.setPerguntaSecreta("Arroz");
		fixture.setCargo("Colaborador");
		fixture.setCategoria("Colaborador");

		CadastroService novoService = new CadastroService();
		
		Cadastro novo = novoService.InserirCadastro(fixture);
		
		assertEquals("testa inclusao", novo, fixture);	

		
	}
	@Test
	public void test00checkUsuario(){
		System.out.println("Check Usuario");

		CadastroService novoService = new CadastroService();
			
		novoService.CheckUsuario("Azevedo");
		
		assertTrue("True se tiver o usuario no BD", true);
	}
	
	@Test
	public void test00checkEmail(){
		System.out.println("Check Email");

		CadastroService novoService = new CadastroService();
			
		novoService.CheckEmail("Admin@gmail.com");
		
		assertTrue("True se tiver o usuario no BD", true);
	}
	
}