
import ModelClassifier.ModelClassifier;
import ModelClassifier.ModelGenerator;
import java.io.File;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.core.stemmers.LovinsStemmer;
import weka.core.stemmers.Stemmer;
import weka.core.stopwords.WordsFromFile;
import weka.core.tokenizers.NGramTokenizer;

/**
 * This is a classifier for wikihow dataset  
 * @author Daria Maggi and Marsha Gomez 
 * Data Mining and Machine Learning University of Pisa
 * Github link: https://github.com/dariamaggi/parser
 */
public class Training {

    public static final String DATASETPATH = "D:\\GitHub\\parser\\data\\cleaned\\AllCategories.arff";
    public static final String MODELPATH = "D:\\Downloads\\weka-example-master\\weka-example-master\\data\\";

    public static void main(String[] args) throws Exception {
        System.out.print("\n ---- START ----");
        int minTermFreq = 2;
        boolean useStemmer = false;
        boolean useIdf = true;
        int maxGrams = 2;
        int minGrams = 2;
        
        ModelGenerator mg = new ModelGenerator();

        Instances dataset = mg.loadDataset(DATASETPATH);

        // -- Filter filter = new Normalize();
        StringToWordVector filter = new StringToWordVector();
        filter.setWordsToKeep(1000000);

        // divide dataset to train dataset 80% and test dataset 20%
        int trainSize = (int) Math.round(dataset.numInstances() * 0.8);
        int testSize = dataset.numInstances() - trainSize;

        dataset.randomize(new Debug.Random(1));// if you comment this line the accuracy of the model will be droped from 96.6% to 80%
        
        System.out.print("\n ---- SET CONFIGURATION ----");

        if(useIdf){
            filter.setIDFTransform(true);
        }
        filter.setTFTransform(true);
        filter.setLowerCaseTokens(true);
        filter.setOutputWordCounts(true);
        filter.setMinTermFreq(minTermFreq);
        filter.setNormalizeDocLength(new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,StringToWordVector.TAGS_FILTER));
        NGramTokenizer t = new NGramTokenizer();
        t.setNGramMaxSize(maxGrams);
        t.setNGramMinSize(minGrams);    
        filter.setTokenizer(t); 
        
        // Stop Words
        // -- WordsFromFile stopwords = new WordsFromFile();
        // -- stopwords.setStopwords(new File("D:\\GitHub\\parser\\JavaApp\\MultiClass\\src\\data\\stopwords.txt"));
        
        // -- filter.setStopwordsHandler(stopwords);
        if (useStemmer){
            Stemmer s = new /*Iterated*/LovinsStemmer();
            filter.setStemmer(s);
        }
        //Normalize dataset
        filter.setInputFormat(dataset);
        Instances datasetnor = Filter.useFilter(dataset, filter);

        Instances traindataset = new Instances(datasetnor, 0, trainSize);
        Instances testdataset = new Instances(datasetnor, trainSize, testSize);

        System.out.print("\n ---- SMO MODEL ----");
        // build classifier with train dataset             
        SMO smo = (SMO) mg.buildClassifier(traindataset, "SMO");

        // Evaluate classifier with test dataset
        String evalsummary = mg.evaluateModel(smo, traindataset, testdataset);
        System.out.println("Evaluation: " + evalsummary);

        //Save model 
        mg.saveModel(smo, MODELPATH+"SMO.bin");
        System.out.print("\n ---- SAVE MODEL ----");
        
        
        System.out.print("\n ---- RANDOM FOREST MODEL ----");
        // build classifier with train dataset             
        RandomForest randomForest = (RandomForest) mg.buildClassifier(traindataset, "RANDOMFOREST");

        // Evaluate classifier with test dataset
        evalsummary = "";
        evalsummary = mg.evaluateModel(randomForest, traindataset, testdataset);
        System.out.println("Evaluation: " + evalsummary);

        //Save model 
        mg.saveModel(randomForest, MODELPATH+"RANDOMFOREST.bin");
        System.out.print("\n ---- SAVE MODEL ----");
        
        
        System.out.print("\n ---- J48 MODEL ----");
        // build classifier with train dataset             
        J48 j48 = (J48) mg.buildClassifier(traindataset, "J48");

        // Evaluate classifier with test dataset
        evalsummary = "";
        evalsummary = mg.evaluateModel(j48, traindataset, testdataset);
        System.out.println("Evaluation: " + evalsummary);

        //Save model 
        mg.saveModel(j48, MODELPATH+"J48.bin");
        System.out.print("\n ---- SAVE MODEL ----");
        
        
        
        System.out.print("\n ---- NAIVE BAYES MODEL ----");
        // build classifier with train dataset             
        NaiveBayes naiveBayes = (NaiveBayes) mg.buildClassifier(traindataset, "NAIVEBAYES");

        // Evaluate classifier with test dataset
        evalsummary = "";
        evalsummary = mg.evaluateModel(naiveBayes, traindataset, testdataset);
        System.out.println("Evaluation: " + evalsummary);

        //Save model 
        mg.saveModel(naiveBayes, MODELPATH+"NAIVEBAYES.bin");
        System.out.print("\n ---- SAVE MODEL ----");
        
        
        //classifiy a single instance 
        // -- ModelClassifier cls = new ModelClassifier();
        // -- String classname = cls.classifiy(Filter.useFilter(cls.createInstance(1.6, 0.2, 0), filter), MODElPATH);
        // -- System.out.println("\n The class name for the instance with petallength = 1.6 and petalwidth =0.2 is  " +classname);
        
        System.out.print("\n ---- FINISH ----");

    }

}
