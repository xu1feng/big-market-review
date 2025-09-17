package edu.xyf.trigger.api;


import edu.xyf.types.model.Response;

public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}
