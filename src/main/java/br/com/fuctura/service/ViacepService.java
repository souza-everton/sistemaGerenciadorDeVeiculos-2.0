package br.com.fuctura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fuctura.dto.EnderecoDTO;


public class ViacepService {

	EnderecoDTO enderecoDto = new EnderecoDTO();
	public EnderecoDTO getEndereco(String cep) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/")).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			ObjectMapper mapper = new ObjectMapper();
			enderecoDto = mapper.readValue(response.body(), EnderecoDTO.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enderecoDto;
	}
	
	
}
