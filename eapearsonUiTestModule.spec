/*
A KBase module: eapearsonUiTestModule
*/

module eapearsonUiTestModule {
  typedef struct {
    string message;
  } SimpleResult;

    typedef structure {
      string message;
      int elapsed;
    } TestResult;

    funcdef run_time_test(int delay) returns (TestResult);

    funcdef small_report() returns SimpleResult;

    funcdef medium_report() returns SimpleResult;

    funcdef large_report() returns SimpleResult;
};
