/**
 *
 */
package file_handling;

import file_handling.manager.ConsoleManager;
import file_handling.service.MemberService;

/**
 * @author EmericStophe
 *
 */
public class MemberApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleManager.getInstance().printToConsole(MemberApplication.class.getName() + " - Start", true);
		ConsoleManager.getInstance().consoleLineBreak();

		// instantiate application
		MemberService applicationService = new MemberService();

		// launch application
		applicationService.run();

		ConsoleManager.getInstance().consoleLineBreak();
		ConsoleManager.getInstance().printToConsole(MemberApplication.class.getName() + " - End", true);

		ConsoleManager.getInstance().closeScanner();
	}

}
