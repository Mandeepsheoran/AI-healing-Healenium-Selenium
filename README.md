# AI-healing-Healenium-Selenium
AI powered Healenium improves the stability of Selenium test by auto healing the failed locators.

Healenium is based on machine learning algoritham called LCS(Longest common subsequence).

This project has selenium framework for web tests which is running with Healenium. Healenium has following components,:
1. Healenium-web
2. Healenium-backend
3. Postgresql db
4. Healenium-selector-imitator

First component will be bundled as pom dependency and rest three will be installed as docker images.

Required docker-compose file is attached in project.

One DB query folder also need to be created at the same location where docker-compose is placed. 
This structure should be "./db/sql/init.sql". This required sql file is also attached in project.

Healenium properties should be available directly under /src/test/resources. For reports, one plugin for hlm-report need to be added in maven pom.

All the test with annotation @DisabledHealing will be ignored in AI healing.

One successful execution has to be done of test cases before using this healing capabilities. These successful locators will be saved in postgresql database
and will be used for tree-comparing in next iteration when selenium will throw no such element exception.

After successful execution, we will see one report link on console which we can use for analysis purpose. This report will have details of failed and healed locators.

Sample Healenium for healed locators:


![image](https://user-images.githubusercontent.com/70449523/227504777-cca4b7bd-003a-4590-b13d-f5d5e2f11956.png)


Healenium working design for web applications:

![healenium](https://user-images.githubusercontent.com/70449523/227505274-d020a439-a89d-410f-82d6-57fc6c55814d.png)
