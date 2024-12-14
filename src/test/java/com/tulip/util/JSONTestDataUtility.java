package com.tulip.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONTestDataUtility {

    public static TestDataContainer readTestData(String filePath) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), TestDataContainer.class);
    }

    @DataProvider(name = "JobCountTestData")
    public Object[][] getJobCountData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.JobCountTestData> testData = testDataContainer.getJobCountTestData();
        Object[][] data = new Object[testData.size()][3];
        for(int i = 0 ; i < testData.size() ; i ++){
            data[i][0] = testData.get(i).getJobCount();
            data[i][1] = testData.get(i).getPageURLContent();
            data[i][2] = testData.get(i).getTableHeadingValue();
        }
        return data;
    }

    @DataProvider(name = "ViewAllCustomerTestData")
    public Object[][] getViewAllCustomerTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.ViewAllCustomerStoryTestData> testData = testDataContainer
                .getViewAllCustomerStoryTestData();
        Object[][] data = new Object[testData.size()][3];
        for(int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
            data[i][1] = testData.get(i).getFilterLabel();
            data[i][2] = testData.get(i).getFilterText();
        }
        return data;
    }

    @DataProvider(name = "CustomerSuccessStoryTestData")
    public Object[][] getCustomerSuccessStoryTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.CustomerSuccessStoryTestData> testData = testDataContainer
                .getCustomerSuccessStoryTestData();
        Object[][] data = new Object[testData.size()][3];
        for(int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
            data[i][1] = testData.get(i).getFilterLabel();
            data[i][2] = testData.get(i).getFilterText();
        }
        return data;
    }

    @DataProvider(name = "CaseStudiesTestData")
    public Object[][] getCaseStudiesTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.CaseStudiesTestData> testData = testDataContainer
                .getCaseStudiesTestData();
        Object[][] data = new Object[testData.size()][2];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
            data[i][1] = testData.get(i).getPostTextValue();
        }
        return data;
    }

    @DataProvider(name = "MasterClassTestData")
    public Object[][] getMasterClassTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.MasterClassTestData> testData = testDataContainer
                .getMasterClassTestData();
        Object[][] data = new Object[testData.size()][2];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
            data[i][1] = testData.get(i).getPostTextValue();
        }
        return data;
    }

    @DataProvider(name = "PartnersTestData")
    public Object[][] getPartnersTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.PartnersTestData> testData = testDataContainer
                .getPartnersTestData();
        Object[][] data = new Object[testData.size()][1];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
        }
        return data;
    }

    @DataProvider(name = "SecurityAndIntegratorsTestData")
    public Object[][] getSecurityAndIntegratorTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.SecurityAndIntegratorsTestData> testData = testDataContainer
                .getSecurityAndIntegratorsTestData();
        Object[][] data = new Object[testData.size()][4];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
            data[i][1] = testData.get(i).getTextContainer();
            data[i][2] = testData.get(i).getExtensibilityHeadingValue();
            data[i][3] = testData.get(i).getSecurityHeadingValue();
        }
        return data;
    }

    @DataProvider(name = "RetailExcellenceTestData")
    public Object[][] getRetailExcellenceTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.RetailExcellenceTestData> testData = testDataContainer
                .getRetailExcellenceTestData();
        Object[][] data = new Object[testData.size()][3];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getPageURLContent();
            data[i][1] = testData.get(i).getSubHeadingContainer();
            data[i][2] = testData.get(i).getHeadingHeaderText();
        }
        return data;
    }

    @DataProvider(name = "VideoOperationsTestData")
    public Object[][] getVideoOperationsTestData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.VideoOperationsTestData> testData = testDataContainer
                .getVideoOperationsTestData();
        Object[][] data = new Object[testData.size()][6];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getVideoTitleContainer();
            data[i][1] = testData.get(i).getVideoSubtitleValue();
            data[i][2] = testData.get(i).getVideoQualityValue();
            data[i][3] = testData.get(i).getVideoPlaybackRate();
            data[i][4] = testData.get(i).getSecondsToOffsetTheVideo();
            data[i][5] = testData.get(i).getVideoCount();
        }
        return data;
    }

    @DataProvider(name = "BrochurePageTestData")
    public Object[][] getBrochurePageTesData() throws IOException {
        TestDataContainer testDataContainer = JSONTestDataUtility.readTestData
                ("src/test/resources/TestData.json");
        List<TestDataContainer.BrochurePageTestData> testData = testDataContainer
                .getBrochurePageTestData();
        Object[][] data = new Object[testData.size()][2];
        for (int i = 0 ; i < testData.size() ; i++) {
            data[i][0] = testData.get(i).getBrochureTitle();
            data[i][1] = testData.get(i).getBrochureURLValue();
        }
        return data;
    }

    public static class TestDataContainer {

        private List<JobCountTestData> jobCountTestData;

        private List<ViewAllCustomerStoryTestData> viewAllCustomerStoryTestData;

        private List<CustomerSuccessStoryTestData> customerSuccessStoryTestData;

        private List<CaseStudiesTestData> caseStudiesTestData;

        private List<MasterClassTestData> masterClassTestData;

        private List<PartnersTestData> partnersTestData;

        private List<SecurityAndIntegratorsTestData> securityAndIntegratorsTestData;

        private List<RetailExcellenceTestData> retailExcellenceTestData;

        private List<VideoOperationsTestData> videoOperationsTestData;

        private List<BrochurePageTestData> brochurePageTestData;

        public List<JobCountTestData> getJobCountTestData() {
            return jobCountTestData;
        }

        public List<ViewAllCustomerStoryTestData> getViewAllCustomerStoryTestData() {
            return viewAllCustomerStoryTestData;
        }

        public List<CustomerSuccessStoryTestData> getCustomerSuccessStoryTestData() {
            return customerSuccessStoryTestData;
        }

        public List<CaseStudiesTestData> getCaseStudiesTestData() {
            return caseStudiesTestData;
        }

        public List<MasterClassTestData> getMasterClassTestData() {
            return masterClassTestData;
        }

        public List<PartnersTestData> getPartnersTestData() {
            return partnersTestData;
        }

        public List<SecurityAndIntegratorsTestData> getSecurityAndIntegratorsTestData() {
            return securityAndIntegratorsTestData;
        }

        public List<RetailExcellenceTestData> getRetailExcellenceTestData() {
            return retailExcellenceTestData;
        }

        public List<VideoOperationsTestData> getVideoOperationsTestData() {
            return videoOperationsTestData;
        }

        public List<BrochurePageTestData> getBrochurePageTestData() {
            return brochurePageTestData;
        }

        public static class JobCountTestData {

            private int jobCount;

            private String pageURLContent;

            private String tableHeadingValue;

            public int getJobCount() {
                return jobCount;
            }

            public String getPageURLContent() {
                return pageURLContent;
            }

            public String getTableHeadingValue() {
                return tableHeadingValue;
            }
        }

        public static class ViewAllCustomerStoryTestData {

            private String pageURLContent;

            private String filterLabel;

            private String filterText;

            public String getPageURLContent() {
                return pageURLContent;
            }

            public String getFilterLabel() {
                return filterLabel;
            }

            public String getFilterText() {
                return filterText;
            }
        }

        public static class CustomerSuccessStoryTestData{

            private String pageURLContent;

            private String filterLabel;

            private String filterText;

            public String getPageURLContent() {
                return pageURLContent;
            }

            public String getFilterLabel() {
                return filterLabel;
            }

            public String getFilterText() {
                return filterText;
            }
        }

        public static class CaseStudiesTestData {

            private String pageURLContent;

            private String postTextValue;

            public String getPageURLContent() {
                return pageURLContent;
            }

            public String getPostTextValue() {
                return postTextValue;
            }
        }

        public static class MasterClassTestData{

            private String pageURLContent;

            private String postTextValue;

            public String getPageURLContent() {
                return pageURLContent;
            }

            public String getPostTextValue() {
                return postTextValue;
            }
        }

        public static class PartnersTestData{

            private String pageURLContent;

            public String getPageURLContent() {
                return pageURLContent;
            }
        }

        public static class SecurityAndIntegratorsTestData{

            private String pageURLContent;

            private String[] textContainer;

            private String extensibilityHeadingValue;

            private String securityHeadingValue;

            public String getPageURLContent(){
                return pageURLContent;
            }

            public String[] getTextContainer(){
                return textContainer;
            }

            public String getExtensibilityHeadingValue() {
                return extensibilityHeadingValue;
            }

            public String getSecurityHeadingValue() {
                return securityHeadingValue;
            }
        }

        public static class RetailExcellenceTestData{

            private String pageURLContent;

            private List<String> subHeadingContainer;

            private String headingHeaderText;

            public String getPageURLContent() {
                return pageURLContent;
            }

            public List<String> getSubHeadingContainer() {
                return subHeadingContainer;
            }

            public String getHeadingHeaderText() {
                return headingHeaderText;
            }
        }

        public static class VideoOperationsTestData{

            private List<String> videoTitleContainer;

            private String videoSubtitleValue;

            private String videoQualityValue;

            private String videoPlaybackRate;

            private int secondsToOffsetTheVideo;

            private int videoCount;

            public List<String> getVideoTitleContainer() {
                return videoTitleContainer;
            }

            public String getVideoSubtitleValue() {
                return videoSubtitleValue;
            }

            public String getVideoQualityValue() {
                return videoQualityValue;
            }

            public String getVideoPlaybackRate() {
                return videoPlaybackRate;
            }

            public int getSecondsToOffsetTheVideo() {
                return secondsToOffsetTheVideo;
            }

            public int getVideoCount() {
                return videoCount;
            }
        }

        public static class BrochurePageTestData{

            private String brochureTitle;

            private String brochureURLValue;

            public String getBrochureTitle() {
                return brochureTitle;
            }

            public String getBrochureURLValue() {
                return brochureURLValue;
            }
        }
    }
}
