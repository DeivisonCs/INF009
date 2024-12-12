package br.ifba.api.petcommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ifba.api.petcommerce.dtos.ClienteDTO;
import br.ifba.api.petcommerce.entities.Cliente;
import br.ifba.api.petcommerce.entities.Endereco;
import br.ifba.api.petcommerce.respositories.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		return new ClienteDTO(clienteRepository.save(new Cliente(clienteDTO)));
	}

	public List<ClienteDTO> listar() {
		return clienteRepository.findAll().stream().map(ClienteDTO::new).toList();
	}

	public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isEmpty()) {
			return null;
		}else {
			Cliente cliente = clienteOptional.get();
			cliente.setNome(clienteDTO.nome());
			cliente.setEmail(clienteDTO.email());
			cliente.setTelefone(clienteDTO.telefone());
			cliente.setEndereco(new Endereco(clienteDTO.endereco()));
			return new ClienteDTO(clienteRepository.save(cliente));
		}
	}
	
	public ClienteDTO deletar(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isEmpty()) {
			return null;
		}
		clienteRepository.deleteById(id);
		return new ClienteDTO(clienteOptional.get());
	}
}
