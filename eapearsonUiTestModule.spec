/*
A KBase module: eapearsonUiTestModule
*/

module eapearsonUiTestModule {
    typedef structure {
      string message;
      int elapsed;
    } TestResult;

    funcdef run_time_test(int delay) returns (TestResult);
};
