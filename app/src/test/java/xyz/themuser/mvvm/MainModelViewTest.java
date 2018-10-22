package xyz.themuser.mvvm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class MainModelViewTest {

    @Mock
    private
    IRepository repository;

    @InjectMocks
    private MainViewModel vm;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(repository.getItem()).thenReturn(new Repository.Item("1000", "234"));
    }

    @Test
    public void testLoadRepository_success() {
        Assert.assertNull(vm.first.get());
        Assert.assertNull(vm.second.get());

        vm.loadRepository(repository);

        Assert.assertNotNull(vm.first.get());
        Assert.assertNotNull(vm.second.get());
    }

    @Test
    public void testSum_correctResult() {
        vm = new MainViewModel(this.repository);
        Assert.assertNull(vm.result.get());

        this.vm.sum();
        Assert.assertEquals("1234", vm.result.get());
    }

    @Test
    public void testOnFirstTextChanged_correctResult() {
        vm = new MainViewModel(this.repository);
        Assert.assertNull(vm.result.get());
        Assert.assertEquals("1000", vm.first.get());

        this.vm.onFirstTextChanged("999", 0, 0, 0);
        Assert.assertEquals("999", vm.first.get());
        Assert.assertEquals("234", vm.second.get());
        Assert.assertEquals("1233", vm.result.get());
    }

    @Test
    public void testOnSecondTextChanged_correctResult() {
        vm = new MainViewModel(this.repository);
        Assert.assertNull(vm.result.get());
        Assert.assertEquals("234", vm.second.get());

        this.vm.onSecondTextChanged("1", 0, 0, 0);
        Assert.assertEquals("1000", vm.first.get());
        Assert.assertEquals("1", vm.second.get());
        Assert.assertEquals("1001", vm.result.get());
    }

    @Test
    public void testOnBtnSumClick_correctResult() {
        vm = new MainViewModel(this.repository);
        Assert.assertNull(vm.result.get());

        this.vm.onBtnSumClick(null);
        Assert.assertEquals("1000", vm.first.get());
        Assert.assertEquals("234", vm.second.get());
        Assert.assertEquals("1234", vm.result.get());
    }
}
