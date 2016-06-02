package com.astontech.hr.services;

import com.astontech.hr.domain.GlobalParameters;

import java.util.Iterator;

/**
 * Created by Bipin on 5/12/2016.
 */
public interface GlobalParametersService {

    Iterable<GlobalParameters> listAllGlobalParameters();

    GlobalParameters getGlobalParametersById(Integer id);

    GlobalParameters saveGlobalParameters(GlobalParameters user);

    Iterable<GlobalParameters> saveGlobalParametersList(Iterable<GlobalParameters> globalParametersIterable);

    void deleteGlobalParameters(Integer id);
}
