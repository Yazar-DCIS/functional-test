<h2>Automation Testing for products in Core Sites(AIC,ID,DUS,USC,FR)</h2>
<h3>Executing Application Scripts</h3>
<b>Step 1: Set up the project-Installations</b>
<ul>
<li>Install Gradle 2.2.1 which is downloadable as a zip file at <a href="http://www.gradle.org/downloads">Download Gradle</a></li>
<li>Java 1.8 which is downloadable as a zip file at <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">Download Java</a></li></ul>

<b>Step 2: Clone from git</b>
<ul>
<li>Clone the source repository of "functional-test-scripts-coresites" from git.<br />
<ul><li>git clone https://github.com/FormsDirect/functional-test-scripts-coresite.git</li></ul></ul>


<b>Step 3: Script Execution</b><br/>
<ul>
In command-line, move to the containing directory(functional-test-scripts-coresites) and execute the script using the commands given below<br /><br/>
<b>Sample commands to execute scripts</b><br/>
<li>./gradlew build -Dsite.name=FR (if test not specified then it will be default:EligibilityQuestionsTest,RegistrationTest,PaymentTest,SimpleQuestionsTest)</li>
<li>./gradlew build -Dsite.name=AIC -Dproduct=n400 -Dtest=RegistrationTest,PaymentTest,SimpleQuestionsTest</li>
<li>./gradlew build -Dsite.name=DUS -Dproduct=n400 -Dtest=EligibilityQuestionsTest,RegistrationTest,PaymentTest</li>
<li>./gradlew build -Dsite.name=USC -Dproduct=n400 <br>-Dtest=EligibilityQuestionsTest,RegistrationTest,PaymentTest,SimpleQuestionsTest -Dflowname=Flow1</li>
<li>./gradlew build -Dsite.name=SEQAFRSTAGING -Dproduct=n400se <br>-Dtest=RegistrationTest,PaymentTest,SimpleQuestionsTest -Dflowname=Flow1</li>
<li>./gradlew build -Dsite.name=ID -Dproduct=n400 -Dtest=LoginTest,PaymentTest,SimpleQuestionsTest <br>-Dflowname=Flow1 -Dusername=orina.moorthy@dcis.net -Dpassword=A12345678</li>

<li>NOTE:
<ul>
<li>If <b>-Dtest</b> property should passed in command line with the respective order seperated by comma(,)from which the application will get executed.<br><b>-Dtest</b> argument if not passed application will get executed from EQ up to Print</li>
<li>If <b>-Dproduct</b> property is not passed in command line all products(18) will get executed</li>
<li>If <b>-Dflowname</b> property is not passed in command line all flows of the product specified will get executed</li>
<li>The <b>-Dusername</b> property should be passed in command line if the test scenario is <b>LoginTest</b></li>
<li><i>All the arguments passed in command line are case-sensitive, refer the values to be passed below</i></li></ul></li></ul>

<b>Values for Script Execution</b><br/>
<ul>
<li>Value given to <b>-Dproduct</b> will be the <b>Application</b> that gets executed<br/></li>
<ul><i>
<li>i102 || i129f || i130 || i130i485 || i131 || i134 || i485 || i539 || i751 || i765 || i821 || <br>
i821d || i824 || i90 || n400 || n565 || n600</li>
<li>i129fqa || i130qa || i130i485qa || i485qa || i539qa || i821dqa || n600qa</li></i>
<li>If -Dproduct=allproducts is given, all products with single flow will be executed</li>
<li>If -Dproduct=comparepdf is given then the pdf of the product given in respective xml will be compared and results will be stored in respective product folder</li>
<li>If -Dproduct=test is given, the products and flows that are called in test.xml(src/test/resources/testsuites/test.xml)  will be get executed</li>
</ul>

<li>Value given to <b>-Dsite.name</b> is the respective <b>NAME of URL</b> defined<br/></li>
<ul><i>Can be given in command-line or in the respective xml<br>
<li>AIC || ID || DUS || USC || FR</li>
</i></ul>

<li>Value given to <b>-Dsite.url</b> is the respective <b>URL</b> defined<br/></li>
<ul><i>Can be given in command-line or in the respective xml<br>
<li>ex-For FR - https://www.fileright.com/ ||  https://stage.fileright.com/</li>
</i></ul>

<li>Value given to <b>-Dtest</b> will be the <b>tasks</b> for the application</li>
<ul>
<li> -Dtest=EligibilityQuestionsTest </li>
<li> -Dtest=RegistrationTest</li>
<li> -Dtest=PaymentTest </li>
<li> -Dtest=SimpleQuestionsTest </li>
<li> -Dtest=LoginTest <br>For LoginTest using registered user-name and continue with the application</li>
<li> <i>Note: Order has be passed in command line;<br>Example if SQ needs to be tested with EQ then the -Dtest will be <br>-Dtest=EligibilityQuestionsTest,RegistrationTest,PaymentTest,SimpleQuestionsTest<i><br><br></li>
</ul>
<ul>
<li>Value given to <b>flowname</b> will be the respective scenarios named(drafted in productname/src/test/resources/productname/flows.xls) for the product</li>
<li>To run only the EQ of a product then <b>-Dsuite.name=eq</b> will be the respective xml named(drafted in productname/src/test/resources/productname/testsuites/eq.xml) for the product</li>
<li>To run only the SQ of a product then <b>-Dsuite.name=sq</b> will be the respective xml named(drafted in productname/src/test/resources/productname/testsuites/sq.xml) for the product</li>
<li>To run a product entire from EQ to Print then <b>-Dsuite.name=productname</b> will be the respective xml named(drafted in productname/src/test/resources/productname/testsuites/productname.xml) for the product</li>
</ul>

<b>Output Folder</b><br/>
<ul>
<li>Once the execution is completed the customized TestNG report will be generated in 
<b><i>build/reports/tests/index.html</i></b></li>
<ul><li>Selecting the <b>Reporter output link</b> in the index.html page,the customized reports of copy validations will get displayed</li>
<li>Selecting the <b>Results link</b> in the index.html page,the customized reports of the passed and failed tests will get displayed</li>
</ul></ul>
