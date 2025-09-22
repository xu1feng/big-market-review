package edu.xyf.domain.strategy.service.armory.algorithm;

import edu.xyf.domain.strategy.repository.IStrategyRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/22 19:23
 */

public abstract class AbstractAlgorithm implements IAlgorithm {

    @Resource
    protected IStrategyRepository repository;

    protected final SecureRandom secureRandom = new SecureRandom();

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum Algorithm {
        O1("o1Algorithm"),
        OLogN("oLogNAlgorithm");

        private String key;
    }

}
