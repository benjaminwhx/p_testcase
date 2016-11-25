package com.jd.bt.theories;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.Arrays;
import java.util.List;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午0:15
 */
public class NameSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        PotentialAssignment nameAssigment1 = PotentialAssignment.forValue("name", "Tony");
        PotentialAssignment nameAssigment2 = PotentialAssignment.forValue("name", "Jim");
        return Arrays.asList(new PotentialAssignment[]{nameAssigment1, nameAssigment2});
    }
}
