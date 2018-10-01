package xyz.themuser.mvvm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class MainModelViewTest {
    @Mock
    private Repository repository;

    private MainViewModel mainViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainViewModel = new MainViewModel(repository);
    }

    @Test
    public void testSum_correct() {

    }
}
