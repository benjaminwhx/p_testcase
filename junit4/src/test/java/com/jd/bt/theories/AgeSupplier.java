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
public class AgeSupplier extends ParameterSupplier {
    
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        PotentialAssignment ageAssignment1 = PotentialAssignment.forValue("age", 10);
        PotentialAssignment ageAssignment2 = PotentialAssignment.forValue("age", 20);
        return Arrays.asList(new PotentialAssignment[]{ageAssignment1, ageAssignment2});
    }
}
