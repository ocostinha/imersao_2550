package br.com.fiap.imersao_2550.config;

import br.com.fiap.imersao_2550.commons.mappers.EnderecoMapper;
import br.com.fiap.imersao_2550.commons.mappers.EnderecoMapperImpl;
import br.com.fiap.imersao_2550.commons.mappers.TelefoneMapper;
import br.com.fiap.imersao_2550.commons.mappers.TelefoneMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {
    @Bean
    @Primary
    public TelefoneMapper telefoneMapper() {
        return new TelefoneMapperImpl();
    }

    @Bean
    @Primary
    public EnderecoMapper enderecoMapper() { return new EnderecoMapperImpl(); }
}
