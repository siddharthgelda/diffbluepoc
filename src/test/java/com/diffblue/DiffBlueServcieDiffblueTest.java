package com.diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisabledInAotMode
@ContextConfiguration(classes = {DiffBlueServcie.class})
@ExtendWith(SpringExtension.class)
class DiffBlueServcieDiffblueTest {
    @MockBean
    private EmpDetailsRepo empDetailsRepo;

    @Autowired
    private DiffBlueServcie diffBlueServcie;

    /**
     * Test {@link DiffBlueServcie#validateEmailid(String)}.
     * <ul>
     *   <li>When {@code 42 Main St}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#validateEmailid(String)}
     */
    @Test
    @DisplayName("Test validateEmailid(String); when '42 Main St'; then return 'false'")
    void testValidateEmailid_when42MainSt_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(diffBlueServcie.validateEmailid("42 Main St"));
    }

    /**
     * Test {@link DiffBlueServcie#validateEmailid(String)}.
     * <ul>
     *   <li>When {@code jane.doe@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#validateEmailid(String)}
     */
    @Test
    @DisplayName("Test validateEmailid(String); when 'jane.doe@example.org'; then return 'true'")
    void testValidateEmailid_whenJaneDoeExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(diffBlueServcie.validateEmailid("jane.doe@example.org"));
    }

    /**
     * Test {@link DiffBlueServcie#getEmpDetails(int)}.
     * <ul>
     *   <li>Then return {@link EmpDTO#EmpDTO(int, String, String)} with id is one and
     * {@code Name} and {@code Dept}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#getEmpDetails(int)}
     */
    @Test
    @DisplayName("Test getEmpDetails(int); then return EmpDTO(int, String, String) with id is one and 'Name' and 'Dept'")
    void testGetEmpDetails_thenReturnEmpDTOWithIdIsOneAndNameAndDept() {
        // Arrange
        ArrayList<EmpDTO> empDTOList = new ArrayList<>();
        EmpDTO empDTO = new EmpDTO(1, "Name", "Dept");

        empDTOList.add(empDTO);
        when(empDetailsRepo.getEmps()).thenReturn(empDTOList);

        // Act
        EmpDTO actualEmpDetails = diffBlueServcie.getEmpDetails(1);

        // Assert
        verify(empDetailsRepo).getEmps();
        assertSame(empDTO, actualEmpDetails);
    }

    /**
     * Test {@link DiffBlueServcie#getEmpDetails(int)}.
     * <ul>
     *   <li>Then return {@link EmpDTO#EmpDTO(int, String, String)} with id is one and
     * {@code Name} and {@code Dept}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#getEmpDetails(int)}
     */
    @Test
    @DisplayName("Test getEmpDetails(int); then return EmpDTO(int, String, String) with id is one and 'Name' and 'Dept'")
    void testGetEmpDetails_thenReturnEmpDTOWithIdIsOneAndNameAndDept2() {
        // Arrange
        ArrayList<EmpDTO> empDTOList = new ArrayList<>();
        empDTOList.add(mock(EmpDTO.class));
        EmpDTO empDTO = new EmpDTO(1, "Name", "Dept");

        empDTOList.add(empDTO);
        when(empDetailsRepo.getEmps()).thenReturn(empDTOList);

        // Act
        EmpDTO actualEmpDetails = diffBlueServcie.getEmpDetails(1);

        // Assert
        verify(empDetailsRepo).getEmps();
        assertSame(empDTO, actualEmpDetails);
    }

    /**
     * Test {@link DiffBlueServcie#add(String, String)}.
     * <ul>
     *   <li>When {@code 42}.</li>
     *   <li>Then return eighty-four.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#add(String, String)}
     */
    @Test
    @DisplayName("Test add(String, String); when '42'; then return eighty-four")
    void testAdd_when42_thenReturnEightyFour() {
        // Arrange, Act and Assert
        assertEquals(84, diffBlueServcie.add("42", "42"));
    }
}
