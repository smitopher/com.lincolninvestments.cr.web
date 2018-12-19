// ***************************************************************************
// 
// Test CR Service : AA1F
// 
// ***************************************************************************
// 
// Generated by : CA Plex r7.2.1   (Build 24.003)
// Date - Time  : Friday, December 14, 2018 - 4:09 PM
// Group Model  : O:\OBMOD\Grp\LIPCLASS
// Local Model  : C:\Webclient\LIPCLASS_Local(12142018).mdl
// User         : Admin
// Version      : X12.0
// Level        : V12.0
// Variant      : Base
// Language     : Base
// 
// ***************************************************************************
// 
// Make Processing Support:
/*
@OBJ_SURROGATE=0xFFFFFEF0
@FUNCTION=Test CR Service
@FNCLNGSYS=Java
@IMPLEMENTATION_NAME=AA1F
@TYPE=EXTERNAL
@GENVRL=721
*/


// ***************************************************************************
// External Function: Test CR Service
// ***************************************************************************

package com.lincoln.test;

import ObRun.ObRTTypes.*;
import ObRun.ObFunction.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;


// ***************************************************************************
// The variables used by: Test CR Service
// ***************************************************************************

////////////////////////////////////////////////////////////////
// AA1F Variable Group
public final class AA1F_ObIn extends ObVariableGroupX
{
    ////////////////////////////////////////////////////////////////
    // Members

    ////////////////////////////////////////////////////////////////
    // Constructors
    public AA1F_ObIn(ObFunction fnc)
    {
        super(ObVariableGroup.VT_INPUT, fnc);
        addVariable("AA1F_Input", initvarAA1F_AA1F_Input());
    }

    public AA1F_ObIn(ObApplication obapp)
    {
        super(obapp, ObVariableGroup.VT_INPUT);
        addVariable("AA1F_Input", initvarAA1F_AA1F_Input());
    }

    public AA1F_ObIn()
    {
        super(ObVariableGroup.VT_INPUT, null);
        addVariable("AA1F_Input", initvarAA1F_AA1F_Input());
    }




    ////////////////////////////////////////////////////////////////
    // Input Variable
    public ObVariableX initvarAA1F_AA1F_Input()
    {
        ObVariableX var = new ObVariableX(this, "varAA1F_AA1F_Input");

        var.addField("CRYSPATH", new ObCharFld(ObField.INPUT, 1024, 'c', "CRYSPATH", true, true, false, "", m_obapp, false)); /* CRYS Crystal Report Path */
        var.addField("cmParameter", new ObCharFld(ObField.INPUT, 1024, 'c', "cmParameter", true, true, false, "", m_obapp, false)); /* Test CR Service.Parameter */
        var.addField("CRYSEXPP", new ObCharFld(ObField.INPUT, 1024, 'c', "CRYSEXPP", true, true, false, "", m_obapp, false)); /* CRYS Export Dest Path */

        return var;
    } 

    // End of Input Variable
    ////////////////////////////////////////////////////////////////


}

// ***************************************************************************
