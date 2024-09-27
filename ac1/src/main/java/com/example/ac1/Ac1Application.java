package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.CategoriaProduto;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {
			/*System.out.println("*** CRIANDO AS CATEGORIAS ***");
			CategoriaProduto c1 = categoriaProdutoRepository.save(
					new CategoriaProduto(0, "Eletrodomestico"));
			CategoriaProduto c2 = categoriaProdutoRepository.save(
					new CategoriaProduto(0, "Informatica"));
			System.out.println("*** LISTANDO AS CATEGORIAS ***");
			*/
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.findAll();
			listaCategorias.stream().map(c -> c.getNome()).forEach(System.out::println);

			System.out.println("*** CRIANDO OS PRODUTOS ***");
			produtoRepository.save(new Produto(0L, "Geladeira", 2000.45, listaCategorias.get(0)));
			produtoRepository.save(new Produto(0L, "Computador", 6700.99, listaCategorias.get(1)));
			
			System.out.println("*** LISTANDO OS PRODUTOS ***");
			List<Produto> listaProdutos = produtoRepository.findAll();
			listaProdutos.stream().map(x -> x.getNome()).forEach(System.out::println);

			System.out.println("*** LISTAR POR NOME ***");
			listaProdutos = produtoRepository.findByNome("Computador");
			listaProdutos.stream().map(x -> x.getNome()).forEach(System.out::println);

			System.out.println("*** LISTAR POR PRECO MAIOR ***");
			listaProdutos = produtoRepository.findByMaiorPreco(2415.11);
			listaProdutos.stream().map(x -> x.getNome()).forEach(System.out::println);
			listaProdutos.stream().map(x -> x.getPreco()).forEach(System.out::println);

			System.out.println("*** LISTAR POR PRECO MENOR ***");
			listaProdutos = produtoRepository.findByMenorPreco(2415.11);
			listaProdutos.stream().map(x -> x.getNome()).forEach(System.out::println);
			listaProdutos.stream().map(x -> x.getPreco()).forEach(System.out::println);

			CategoriaProduto cc = categoriaProdutoRepository.findCategoriaProdutoFetchProdutos((long) 1);
			System.out.println(cc.getProdutos().size());

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
