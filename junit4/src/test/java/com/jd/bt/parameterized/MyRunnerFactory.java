package com.jd.bt.parameterized;

import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

/**
 * User: 吴海旭
 * Date: 2016-11-24
 * Time: 下午9:01
 */
public class MyRunnerFactory implements ParametersRunnerFactory {

    @Override
    public Runner createRunnerForTestWithParameters(TestWithParameters test) throws InitializationError {
        return new MyRunnerWithParameters(test);
    }
}
