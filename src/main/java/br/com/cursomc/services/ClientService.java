package br.com.cursomc.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cursomc.domain.City;
import br.com.cursomc.domain.Client;
import br.com.cursomc.domain.Endereco;
import br.com.cursomc.domain.dto.ClientDTO;
import br.com.cursomc.domain.dto.ClientNewDto;
import br.com.cursomc.domain.enums.ClientType;
import br.com.cursomc.repositories.ClientRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	@Autowired
	private CityService cityService;
	@Autowired
	private EnderecoService enderecoService;

	public Client find(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));
	}

	public List<Client> saveAll(List<Client> lista) {
		return this.repository.saveAll(lista);
	}

	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		this.enderecoService.saveAll(obj.getEnderecos());
		return this.repository.save(obj);
	}

	public Client update(Client obj) {
		Client newObj = this.find(obj.getId());
		this.updateData(newObj, obj);
		return this.repository.save(newObj);
	}

	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(Integer id) {
		this.find(id);
		try {
			this.repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.cursomc.services.exceptions.DataIntegrityViolationException(
					"Não é possível excluir cliente");
		}
	}

	public List<Client> findAll() {
		return this.repository.findAll();
	}

	public Page<Client> findPage(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return this.repository.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO dto) {
		return new Client(dto.getId(), dto.getNome(), dto.getEmail(), null, null);
	}

	public Client fromDTO(ClientNewDto newDto) {
		Client cli = new Client(null, newDto.getName(), newDto.getEmail(), newDto.getCpfOrCnpj(),
				ClientType.toEnum(newDto.getType()));
		City city = this.cityService.findOne(newDto.getCityId());
		Endereco end = new Endereco(null, newDto.getLog(), newDto.getName(), newDto.getComplement(),
				newDto.getDistrict(), newDto.getCep(), cli, city);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(newDto.getTelefone1());
		
		if (newDto.getTelefone2() != null) {
			cli.getTelefones().add(newDto.getTelefone2());
		}
		
		if (newDto.getTelefone3() != null) {
			cli.getTelefones().add(newDto.getTelefone3());
		}
		return cli;
	}

}
