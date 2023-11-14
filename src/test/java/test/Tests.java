package test;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {
"." }, glue = { "stepdefs" },
		tags = { "@chrome" },
		plugin=
	{
	"json:target/cucumber-reports/cucumber.json",
	"rerun:target/cucumber-reports/re-run.txt"})

public class Tests extends BaseTest  {
    @Override
    @DataProvider(parallel = false)
   public Object[][] scenarios() {
        return super.scenarios();
    }
}
