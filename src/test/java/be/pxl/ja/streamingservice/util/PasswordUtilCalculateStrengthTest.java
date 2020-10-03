package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilCalculateStrengthTest {

    @Test
    public void PasswordUtilCalculateStrengthLevel0(){
        assertEquals(0,PasswordUtil.calculateStrength("."));
    }

    @Test
    public void PasswordUtilCalculateStrengthLevel1LengthBetween6And10(){
        assertEquals(1,PasswordUtil.calculateStrength("......."));
    }

    @Test
    public void PasswordUtilCalculateStrengthLevel1LengthInclude6And10(){
        assertEquals(1,PasswordUtil.calculateStrength("......"));
        assertEquals(1,PasswordUtil.calculateStrength(".........."));
    }

    @Test
    public void PasswordUtilCalculateStrengthLevel2LengthHigherThan10(){
        assertEquals(2,PasswordUtil.calculateStrength("............"));
    }

    @Test
    public void PasswordUtilCalculateStrengthLevel3LowerCase(){
        assertEquals(3,PasswordUtil.calculateStrength("......m"));
    }
    @Test
    public void PasswordUtilCalculateStrengthLevel4LowerCase(){
        assertEquals(4,PasswordUtil.calculateStrength("..........m"));
    }

    @Test
    public void PasswordUtilCalculateStrengthLevel3Number(){
        assertEquals(3,PasswordUtil.calculateStrength("......7"));
    }
    @Test
    public void PasswordUtilCalculateStrengthLevel4Number(){
        assertEquals(4,PasswordUtil.calculateStrength("..........7"));
    }
    @Test
    public void PasswordUtilCalculateStrengthLevel3SpecialCharacter(){
        assertEquals(3,PasswordUtil.calculateStrength("......$"));
    }
    @Test
    public void PasswordUtilCalculateStrengthLevel4SpecialCharacter(){
        assertEquals(4,PasswordUtil.calculateStrength("..........$"));
    }

    @Test
    public void PasswordUtilCalculateStrengthMultipleNumbers(){
        assertEquals(3,PasswordUtil.calculateStrength("......777"));
    }
    @Test
    public void PasswordUtilCalculateStrengthMultipleLowerCaseLetters(){
        assertEquals(3,PasswordUtil.calculateStrength("......mmm"));
    }
    @Test
    public void PasswordUtilCalculateStrengthMultipleSpecialCharacters(){
        assertEquals(3,PasswordUtil.calculateStrength("......$$$"));
    }

    @Test
    public void PasswordUtilCalculateStrengthLevelmax(){
        assertEquals(8,PasswordUtil.calculateStrength("........$7m"));
    }
}
