package com.astontech.hr.services.Impl;

import com.astontech.hr.domain.GlobalParameters;
import com.astontech.hr.repositories.GlobalParametersRepository;
import com.astontech.hr.services.GlobalParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bipin on 5/12/2016.
 */
@Service
public class GlobalParametersServiceImpl implements GlobalParametersService {

    @Autowired
    private GlobalParametersRepository globalParametersRepository;

    @Override
    public Iterable<GlobalParameters> listAllGlobalParameters() {
        return globalParametersRepository.findAll();
    }

    @Override
    public GlobalParameters getGlobalParametersById(Integer id) {
        return globalParametersRepository.findOne(id);
    }

    @Override
    public GlobalParameters saveGlobalParameters(GlobalParameters globalParameters) {
        return globalParametersRepository.save(globalParameters);
    }

    @Override
    public Iterable<GlobalParameters> saveGlobalParametersList(Iterable<GlobalParameters> globalParametersIterable) {
        return globalParametersRepository.save(globalParametersIterable);
    }

    @Override
    public void deleteGlobalParameters(Integer id) {
        globalParametersRepository.delete(id);
    }
}
