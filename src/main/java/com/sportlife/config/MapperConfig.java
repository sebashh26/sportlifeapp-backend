package com.sportlife.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	//ahecemos esto porque es un singleton y necesitamos q solo devuelva uan iyeccion de dependencia de esto
	//@bean spring maneja en el contenedor tenga una instancia del model mapper de tipo singleson para usarla cuando lo necesitan con autowired
	
	@Bean
	public ModelMapper modelMapper() {
//		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return new ModelMapper();
	}
}
