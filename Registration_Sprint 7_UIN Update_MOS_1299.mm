<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1550387685485" ID="ID_1020570699" MODIFIED="1550387698677" TEXT="Registration - UIN Update">
<node CREATED="1550387758020" ID="ID_84830610" LINK="https://mosipid.atlassian.net/browse/MOS-1299" MODIFIED="1550389228422" POSITION="right" TEXT="MOS-1299">
<edge COLOR="#33cc00"/>
<node COLOR="#33cc00" CREATED="1550387812088" HGAP="13" ID="ID_135829982" MODIFIED="1552037869144" TEXT="Access to UIN update root for RO and Sup" VSHIFT="4">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_1398003454" MODIFIED="1550389347583" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_187037050" MODIFIED="1550389347583" TEXT="Click and procced with the request"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_1481396005" MODIFIED="1550389378581" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_1126748311" MODIFIED="1550389412904" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550387898099" HGAP="16" ID="ID_1604520843" MODIFIED="1550389347584" TEXT="Selection for Child / Adult availble" VSHIFT="-48">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_537270267" MODIFIED="1550389347583" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_1159172760" MODIFIED="1550389347582" TEXT="Click and procced with the request"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_300853243" MODIFIED="1550389378581" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_602685616" MODIFIED="1550389412904" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550387932105" ID="ID_1599243596" MODIFIED="1550389347584" TEXT="Sub-type for UIN Update" VSHIFT="-35">
<node COLOR="#33cc00" CREATED="1550387967136" ID="ID_870654305" MODIFIED="1550389347578" TEXT="Name, Age/Date of Birth, Gender, Address, Contact Details, CNIE/PIN Number, Parent/Guardian Details, Biometrics-Exception, Biometrics-Fingerprints, Biometrics-Iris."/>
</node>
<node COLOR="#33cc00" CREATED="1550387998971" ID="ID_1271251272" MODIFIED="1550389347565" TEXT="RC behavior for UIN update">
<node COLOR="#33cc00" CREATED="1550388028366" ID="ID_1828361519" MODIFIED="1550389347578" TEXT="Pre-registration available">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_1069580088" MODIFIED="1552037902377" TEXT="No">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_977468696" MODIFIED="1550389347577" TEXT="Click and procced with the request"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_1193108848" MODIFIED="1552037899297" TEXT="Yes">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_1025295536" MODIFIED="1550389412903" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388071889" ID="ID_1341633017" MODIFIED="1550389347577" TEXT="Field other than selected sub-type is empty" VSHIFT="22">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_1022144311" MODIFIED="1550389347575" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_885807038" MODIFIED="1550389347575" TEXT="Update the selected field and proceed"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_647397993" MODIFIED="1550389378582" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_1243431101" MODIFIED="1550389412903" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388135915" HGAP="21" ID="ID_1876317643" MODIFIED="1550389347577" TEXT="Full name mandatory for all request" VSHIFT="22">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_1408682804" MODIFIED="1550389347576" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_1508734124" MODIFIED="1550389347575" TEXT="Update the selected field and proceed"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_189663980" MODIFIED="1550389378582" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_366614205" MODIFIED="1550389412903" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388174793" ID="ID_892747230" MODIFIED="1550389347577" TEXT="Age &lt; 5 if UIN update is for Child" VSHIFT="14">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_1160791957" MODIFIED="1550389347576" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_94531819" MODIFIED="1550389347576" TEXT="Update the selected field along with Parent/Guardian Name and UIN and proceed"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_582930949" MODIFIED="1550389378583" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_1628599334" MODIFIED="1550389412902" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388262468" HGAP="13" ID="ID_1484023615" MODIFIED="1550389347575" TEXT="Translation available for Full name and address " VSHIFT="27">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_647124694" MODIFIED="1550389347573" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_1132427296" MODIFIED="1550389347573" TEXT="Update the selected field and proceed"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_305918771" MODIFIED="1550389378583" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_1201033020" MODIFIED="1550389412902" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388358021" ID="ID_241877594" MODIFIED="1550389347574" TEXT="Biometric exception selector enabled always">
<node COLOR="#33cc00" CREATED="1550387844110" ID="ID_1890989039" MODIFIED="1550389347572" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550387867763" ID="ID_667140412" MODIFIED="1550389347573" TEXT="Update the selected field and proceed"/>
</node>
<node COLOR="#ff9900" CREATED="1550387862592" ID="ID_1248266037" MODIFIED="1550389378583" TEXT="No">
<node COLOR="#ff0000" CREATED="1550387880385" ID="ID_280325463" MODIFIED="1550389412902" TEXT="Raise a defect"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388390926" HGAP="22" ID="ID_1466287757" MODIFIED="1550389347572" TEXT="Document behavior" VSHIFT="9">
<node COLOR="#33cc00" CREATED="1550388413474" ID="ID_398353614" MODIFIED="1550389347572" TEXT="Proof of Identity is mandatory for name change."/>
<node COLOR="#33cc00" CREATED="1550388432830" ID="ID_1397486502" MODIFIED="1550389347571" TEXT="Proof of Date of Birth is mandatory for date of birth change if &#x2018;Verified&#x2019; is selected."/>
<node COLOR="#33cc00" CREATED="1550388440140" ID="ID_361476242" MODIFIED="1550389347571" TEXT="Proof of Address is mandatory for address change."/>
<node COLOR="#33cc00" CREATED="1550388447668" ID="ID_623083523" MODIFIED="1550389347571" TEXT="Proof of Relationship is mandatory for Parent/Guardian details change."/>
</node>
<node COLOR="#33cc00" CREATED="1550388478835" HGAP="8" ID="ID_854920427" MODIFIED="1550389347571" TEXT="User has Biometric exception but opted for other update" VSHIFT="12">
<node COLOR="#33cc00" CREATED="1550388570722" ID="ID_1026134412" MODIFIED="1550389347570" TEXT="Adult">
<node COLOR="#33cc00" CREATED="1550388513227" ID="ID_1794610008" MODIFIED="1550389347570" TEXT="biometrics must be captured again"/>
</node>
<node COLOR="#33cc00" CREATED="1550388582549" ID="ID_415709097" MODIFIED="1550389347570" TEXT="Child">
<node COLOR="#33cc00" CREATED="1550388595132" ID="ID_476326352" MODIFIED="1552038059673" TEXT="Biometric should not be captured only for child"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388637092" HGAP="16" ID="ID_1135327969" MODIFIED="1550389347566" TEXT="Fingerprint update" VSHIFT="2">
<node COLOR="#33cc00" CREATED="1550388661723" HGAP="17" ID="ID_1646707874" MODIFIED="1550389347557" TEXT="Adult" VSHIFT="-16">
<node COLOR="#33cc00" CREATED="1550388693203" HGAP="25" ID="ID_181278930" MODIFIED="1550389347566" TEXT="If fingerprint update is selected, all fingerprints (minus exceptions) should be scanned in the configuration left slap + right slap + two thumbs. Else any one biometric should be captured." VSHIFT="-21"/>
</node>
<node COLOR="#33cc00" CREATED="1550388665959" HGAP="18" ID="ID_1168351938" MODIFIED="1550389347557" TEXT="Child" VSHIFT="2">
<node COLOR="#33cc00" CREATED="1550388738096" ID="ID_645957249" MODIFIED="1550389347553" TEXT="Fingerprints of a child should not be captured. Any one fingerprint or iris of the parent/guardian should be captured."/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388754482" HGAP="18" ID="ID_889659686" MODIFIED="1550389347565" TEXT="Iris update" VSHIFT="9">
<node COLOR="#33cc00" CREATED="1550388661723" HGAP="17" ID="ID_390246476" MODIFIED="1550389347558" TEXT="Adult" VSHIFT="-16">
<node COLOR="#33cc00" CREATED="1550388693203" HGAP="29" ID="ID_1637604704" MODIFIED="1550389347549" TEXT="If iris update is selected, both irises (minus exceptions) should be scanned. Else any one biometric should be captured." VSHIFT="-9"/>
</node>
<node COLOR="#33cc00" CREATED="1550388665959" HGAP="16" ID="ID_765710251" MODIFIED="1550389347565" TEXT="Child" VSHIFT="6">
<node COLOR="#33cc00" CREATED="1550388738096" ID="ID_872074069" MODIFIED="1550389347549" TEXT="Iris of a child should not be captured. Any one fingerprint or iris of the parent/guardian should be captured."/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388837706" HGAP="18" ID="ID_1406160580" MODIFIED="1550389347548" TEXT="Face Photo captured" VSHIFT="22">
<node COLOR="#33cc00" CREATED="1550388892167" ID="ID_1157714234" MODIFIED="1550389347548" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550388899986" ID="ID_1619409044" MODIFIED="1550389347548" TEXT="Proceed to next step"/>
</node>
<node COLOR="#ff9900" CREATED="1550388894354" ID="ID_992951317" MODIFIED="1550389378584" TEXT="No">
<node COLOR="#ff0000" CREATED="1550388919798" ID="ID_984421075" MODIFIED="1550389412902" TEXT="Re-capture the face"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388943290" ID="ID_806177834" MODIFIED="1550389347548" TEXT="Exception photo" VSHIFT="23">
<node COLOR="#33cc00" CREATED="1550388987741" ID="ID_58344939" MODIFIED="1550389347547" TEXT="User has biometric exception">
<node COLOR="#33cc00" CREATED="1550388892167" ID="ID_1048298737" MODIFIED="1552038107084" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550388899986" ID="ID_386387501" MODIFIED="1552038107084" TEXT="Capture the exception with face"/>
</node>
<node COLOR="#33cc00" CREATED="1550388894354" ID="ID_788966902" MODIFIED="1550389347547" TEXT="No">
<node COLOR="#33cc00" CREATED="1550388919798" ID="ID_892834742" MODIFIED="1550389347547" TEXT="Proceed to next step"/>
</node>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550389050908" HGAP="18" ID="ID_925298478" MODIFIED="1550389347546" TEXT="Preview and Authentication" VSHIFT="29">
<node COLOR="#33cc00" CREATED="1550389067302" HGAP="15" ID="ID_763021884" MODIFIED="1552038130106" TEXT="With biometric exception" VSHIFT="-21">
<node COLOR="#33cc00" CREATED="1550389102883" ID="ID_952158733" MODIFIED="1550389347544" TEXT="Sup credentials is required"/>
</node>
<node COLOR="#33cc00" CREATED="1550389090191" ID="ID_1993592268" MODIFIED="1552038135622" TEXT="without biometric exception">
<node COLOR="#33cc00" CREATED="1550389115414" ID="ID_841681772" MODIFIED="1550389347544" TEXT="RO credential is enough"/>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550389137714" HGAP="21" ID="ID_613813313" MODIFIED="1550389347546" TEXT="Notification" VSHIFT="29">
<node COLOR="#33cc00" CREATED="1550389148691" ID="ID_145963242" MODIFIED="1552038226303" TEXT="UIN update for contact details">
<node COLOR="#33cc00" CREATED="1550388892167" HGAP="15" ID="ID_1160191788" MODIFIED="1552038247355" TEXT="Yes" VSHIFT="-18">
<node COLOR="#33cc00" CREATED="1552038232472" ID="ID_232854363" MODIFIED="1552038280731" TEXT="Notification is configured in DB">
<node COLOR="#33cc00" CREATED="1552038264374" ID="ID_898216214" MODIFIED="1552038280731" TEXT="Yes">
<node COLOR="#33cc00" CREATED="1550388899986" ID="ID_1893121319" MODIFIED="1550389347545" TEXT="Sent notification as configured"/>
</node>
<node COLOR="#33cc00" CREATED="1550388894354" HGAP="23" ID="ID_1554707866" MODIFIED="1552038245217" TEXT="No" VSHIFT="29">
<node COLOR="#33cc00" CREATED="1550388919798" ID="ID_1512143022" MODIFIED="1550389347543" TEXT="no notification will be sent"/>
</node>
</node>
</node>
<node COLOR="#33cc00" CREATED="1550388894354" HGAP="23" ID="ID_466761334" MODIFIED="1552038245217" TEXT="No" VSHIFT="29">
<node COLOR="#33cc00" CREATED="1550388919798" ID="ID_568221689" MODIFIED="1550389347543" TEXT="no notification will be sent"/>
</node>
</node>
</node>
</node>
<node COLOR="#00cc00" CREATED="1538550071542" HGAP="9" ID="ID_1021783307" MODIFIED="1546498495098" TEXT="Verification of Txn details for Audit purpose" VSHIFT="34">
<edge COLOR="#00cc00"/>
<node COLOR="#00cc00" CREATED="1539003087723" ID="ID_163075645" MODIFIED="1542005044938" TEXT="System capture all Txn details">
<node COLOR="#00cc00" CREATED="1539003122483" ID="ID_1629456931" MODIFIED="1546498515692" TEXT="Store all the details under &quot;Audit_Log&quot; table such as User id or system account; Machine Details; Event Name; Application Name, and Event data including user entered fields."/>
</node>
<node COLOR="#ff0000" CREATED="1539060442854" ID="ID_1191661596" MODIFIED="1542005044938" TEXT="System fails to capture Txn details">
<edge COLOR="#ff0000"/>
<node COLOR="#ff0000" CREATED="1539089688847" ID="ID_795182154" MODIFIED="1542005044938" TEXT="Display appropriate error message / Raise a defect"/>
</node>
</node>
</node>
</node>
</map>
