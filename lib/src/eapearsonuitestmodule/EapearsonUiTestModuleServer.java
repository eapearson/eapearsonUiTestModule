package eapearsonuitestmodule;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import us.kbase.common.service.JsonServerMethod;
import us.kbase.common.service.JsonServerServlet;
import us.kbase.common.service.JsonServerSyslog;
import us.kbase.common.service.RpcContext;

//BEGIN_HEADER
//END_HEADER

/**
 * <p>Original spec-file module name: eapearsonUiTestModule</p>
 * <pre>
 * A KBase module: eapearsonUiTestModule
 * </pre>
 */
public class EapearsonUiTestModuleServer extends JsonServerServlet {
    private static final long serialVersionUID = 1L;
    private static final String version = "0.0.1";
    private static final String gitUrl = "https://github.com/eapearson/eapearsonUiTestModule.git";
    private static final String gitCommitHash = "9215d28dccfe128a4814e54715b767bd868ff379";

    //BEGIN_CLASS_HEADER
    //END_CLASS_HEADER

    public EapearsonUiTestModuleServer() throws Exception {
        super("eapearsonUiTestModule");
        //BEGIN_CONSTRUCTOR
        //END_CONSTRUCTOR
    }

    /**
     * <p>Original spec-file function name: run_time_test</p>
     * <pre>
     * </pre>
     * @param   delay   instance of Long
     * @return   instance of type {@link eapearsonuitestmodule.TestResult TestResult}
     */
    @JsonServerMethod(rpc = "eapearsonUiTestModule.run_time_test", async=true)
    public TestResult runTimeTest(Long delay, RpcContext jsonRpcContext) throws Exception {
        TestResult returnVal = null;
        //BEGIN run_time_test
        returnVal = new TestResult();
        returnVal.setMessage("It worked?");
        returnVal.setElapsed(1L);
        //END run_time_test
        return returnVal;
    }
    @JsonServerMethod(rpc = "eapearsonUiTestModule.status")
    public Map<String, Object> status() {
        Map<String, Object> returnVal = null;
        //BEGIN_STATUS
        returnVal = new LinkedHashMap<String, Object>();
        returnVal.put("state", "OK");
        returnVal.put("message", "");
        returnVal.put("version", version);
        returnVal.put("git_url", gitUrl);
        returnVal.put("git_commit_hash", gitCommitHash);
        //END_STATUS
        return returnVal;
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            new EapearsonUiTestModuleServer().startupServer(Integer.parseInt(args[0]));
        } else if (args.length == 3) {
            JsonServerSyslog.setStaticUseSyslog(false);
            JsonServerSyslog.setStaticMlogFile(args[1] + ".log");
            new EapearsonUiTestModuleServer().processRpcCall(new File(args[0]), new File(args[1]), args[2]);
        } else {
            System.out.println("Usage: <program> <server_port>");
            System.out.println("   or: <program> <context_json_file> <output_json_file> <token>");
            return;
        }
    }
}
