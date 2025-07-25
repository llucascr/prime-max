package core.api.prime_max.testing.archictecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;
import core.api.prime_max.utils.ValidateParameter;
import jakarta.persistence.Entity;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "core.api.prime_max", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

    //Layer
    @ArchTest
    static ArchRule layerTest = layeredArchitecture()
            .consideringAllDependencies()
            .layer("Controller").definedBy("..api..")
            .layer("Services").definedBy("..services..")
            .layer("Repository").definedBy("..repositories..")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Services");

    //Api
    @ArchTest
    static ArchRule controllerTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage("..api..")
            .andShould().haveSimpleNameEndingWith("Controller")
            .andShould().haveSimpleNameNotEndingWith("RestController");

    @ArchTest
    static ArchRule controllerDoNotCallRepositoryTest = ArchRuleDefinition.noClasses()
            .that().resideInAPackage("..api..")
            .should().dependOnClassesThat().resideInAPackage("..repositories..")
            .because("Controller não pode chamar diretamente o repository.");

    @ArchTest
    static ArchRule controllerMethodsTest = ArchRuleDefinition.noMethods()
            .that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
            .should().beAnnotatedWith(RequestMapping.class)
            .andShould().beAnnotatedWith(RestController.class);

    //DTO
    @ArchTest
    static ArchRule dtoTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..dto..")
            .should()
            .notBeRecords()
            .because("Classe responsável pela transferência de dados entre cliente e camada de modelo");

    //Exception
    @ArchTest
    static ArchRule exceptionTest = ArchRuleDefinition.classes()
            .that()
            .areAnnotatedWith(RestControllerAdvice.class)
            .should()
            .resideInAPackage("..exceptions..")
            .because("Pertencem a um pacote de controle de exceções");

    @ArchTest
    static ArchRule exceptionMethodTest = ArchRuleDefinition.methods()
            .that().areAnnotatedWith(ExceptionHandler.class)
            .should().bePublic()
            .because("Metódos Responsáveis por controle e devolutiva de exceção de erros da aplicação");

    //Model
    @ArchTest
    static ArchRule entityTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..models..")
            .because("Classe responsável pela camada de modelo e persistência");

    @ArchTest
    static ArchRule inheritanceEntityTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..models..")
            .andShould().implement(Serializable.class)
            .because("Classe responsável pela camada de modelo e persistência");

    @ArchTest
    static ArchRule fieldsEntityTest = ArchRuleDefinition.fields()
            .that().areDeclaredInClassesThat()
            .resideInAPackage("..models..")
            .should().bePrivate()
            .because("atributos devem ser privados e acessados via método/encapsulamento/construtor");

    //Repository
    @ArchTest
    static ArchRule repositoryTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repositories..").should()
            .beAnnotatedWith(Repository.class)
            .because("Repository é uma classe/interface de persistência @Repository");

    @ArchTest
    static ArchRule repositoryClassInterface = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repositories..")
            .should().beAnnotatedWith(Repository.class)
            .andShould().beInterfaces().because("Classe de contrato com a data base (ORM)");

    //Service
    @ArchTest
    static ArchRule servicesTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..services..")
            .should().beAnnotatedWith(Service.class);

    @ArchTest
    static ArchRule serviceNameHaveBeenFinallyService = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Services");

    @ArchTest
    static ArchRule serviceFieldsHasBeenPrivate = ArchRuleDefinition.fields()
            .that().areDeclaredInClassesThat()
            .areAnnotatedWith(Service.class)
            .should().bePrivate()
            .because("Instâncias e Objetos devem ser privados em sua declaração");

    @ArchTest
    static ArchRule componentIsNotAllowed = ArchRuleDefinition.classes()
            .that().resideInAPackage("..services..")
            .should().notBeAnnotatedWith(Component.class)
            .because("Anotação 'Component' não é permitida no pacote service");

    //Utils
    @ArchTest
    static ArchRule utilsValidateParameterTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..utils..")
            .should().haveSimpleName("ValidateParameter")
            .because("Classe utilitária para conversão de tipo String/Long e seu tratamento em caso de erro");

    @ArchTest
    static ArchRule utilsValidateTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..utils..")
            .should().haveOnlyPrivateConstructors();

    @ArchTest
    static ArchRule utilsValidateMethodTest = ArchRuleDefinition.methods()
            .that().areDeclaredIn(ValidateParameter.class)
            .should().bePublic()
            .because("Para acesso de conversão de tipo String/Long");

    //Logs
    //@ArchIgnore
    @ArchTest
    static ArchRule logTest = ArchRuleDefinition.fields()
            .that().haveRawType(Logger.class)
            .should().bePrivate()
            .andShould().beStatic()
            .andShould().beFinal()
            .allowEmptyShould(true);

    @ArchTest
    static ArchRule log2Test = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    static ArchRule injectionDependencyTest = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
}
