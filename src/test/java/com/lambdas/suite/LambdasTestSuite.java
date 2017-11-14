package com.lambdas.suite;
import com.lambdas.BasicLambdas1;
import com.lambdas.BasicLambdas2;
import com.lambdas.BasicLambdas3;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Created by Nisan on 11/14/2017.
 */

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.lambdas"})
public class LambdasTestSuite {
}
