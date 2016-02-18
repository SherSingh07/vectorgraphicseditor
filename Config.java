/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * Config.java is the configuration file for storing various config params.
 * 
 * Copyright (c) 2011 onwards by WeaveBytes, Inc. 
 * Please reports bugs at weavebytes@gmail.com
 * 
 * This file may be distributed and/or modified under the terms of the 
 * GNU General Public License version 2 as published by the Free Software 
 * Foundation. (See COPYING.GPL for details.)
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 * 
 */

class Config {

    //define commands for buttons
    public static final String CMD_DRAW_RECTANGLE  = "CMD_DRAW_RECTANGLE";
    public static final String CMD_FILL_RECTANGLE  = "CMD_FILL_RECTANGLE";
    public static final String CMD_DRAW_OVAL       = "CMD_DRAW_OVAL";
    public static final String CMD_FILL_OVAL       = "CMD_FILL_OVAL";
    public static final String CMD_DRAW_ROUND_RECT = "CMD_DRAW_ROUND_RECT";
    public static final String CMD_FILL_ROUND_RECT = "CMD_FILL_ROUND_RECT";
    public static final String CMD_DRAW_LINE       = "CMD_DRAW_LINE";
    public static final String CMD_DRAW_HSCROLL    = "CMD_DRAW_HSCROLL";
    public static final String CMD_DRAW_VSCROLL    = "CMD_DRAW_VSCROLL";
    public static final String CMD_DRAW_TRIANGLE   = "CMD_DRAW_TRIANGLE";
    public static final String CMD_FILL_TRIANGLE   = "CMD_FILL_TRIANGLE";
    public static final String CMD_FILL_RHOMBUS    = "CMD_FILL_RHOMBUS";
    public static final String CMD_DRAW_PENTAGON   = "CMD_DRAW_PENTAGON";
    public static final String CMD_FILL_PENTAGON   = "CMD_FILL_PENTAGON";
    public static final String CMD_DRAW_HEXAGON    = "CMD_DRAW_HEXAGON";
    public static final String CMD_FILL_HEXAGON    = "CMD_FILL_HEXAGON";
    public static final String CMD_DRAW_OCTAGON    = "CMD_DRAW_OCTAGON";
    public static final String CMD_FILL_OCTAGON    = "CMD_FILL_OCTAGON";

    public static final String CMD_FILL_HEART      = "CMD_FILL_HEART";
    public static final String CMD_DRAW_HEART      = "CMD_DRAW_HEART";
    public static final String CMD_DRAW_STAR       = "CMD_DRAW_STAR";
    public static final String CMD_FILL_STAR       = "CMD_FILL_STAR";
    public static final String CMD_DRAW_MOON       = "CMD_DRAW_MOON";
    public static final String CMD_DRAW_CALL       = "CMD_DRAW_CALL";
    public static final String CMD_FILL_CALL       = "CMD_FILL_CALL";
    public static final String CMD_DRAW_PICTURE    = "CMD_DRAW_PICTURE";
    public static final String CMD_DRAW_SPIRAL     = "CMD_DRAW_SPIRAL";
    public static final String CMD_DRAW_TARGET     = "CMD_DRAW_TARGET";
    public static final String CMD_FILL_CROSS      = "CMD_FILL_CROSS";
    public static final String CMD_DRAW_TEXT       = "CMD_DRAW_TEXT";
    public static final String CMD_DRAW_TOOTH      = "CMD_DRAW_TOOTH";
    public static final String CMD_HAT             = "CMD_HAT";
	
	public static final String CMD_DRAW_BARGRAPH       = "CMD_DRAW_BARGRAPH";
	public static final String CMD_DRAW_PIECHART       = "CMD_DRAW_PIECHART";
	public static final String CMD_DRAW_LINEGRAPH      = "CMD_DRAW_LINEGRAPH";
	public static final String CMD_DRAW_PROGRESSGRAPH  = "CMD_DRAW_PROGRESSGRAPH";
	public static final String CMD_DRAW_FLOWCHART      = "CMD_DRAW_FLOWCHART";
	public static final String CMD_DRAW_BASICSHAPES    = "CMD_DRAW_BASICSHAPES";
	public static final String CMD_DRAW_SMILEYS        = "CMD_DRAW_SMILEYS";
	public static final String CMD_DRAW_ARROWS         = "CMD_DRAW_ARROWS";
	
	public static final String CMD_FILL_RIGHTARROW     = "CMD_FILL_RIGHTARROW";
	public static final String CMD_FILL_LEFTARROW      = "CMD_FILL_LEFTARROW";
	public static final String CMD_FILL_UPARROW        = "CMD_FILL_UPARROW";
	public static final String CMD_FILL_DOWNARROW      = "CMD_FILL_DOWNARROW";
	public static final String CMD_FILL_LEFTRIGHTARROW = "CMD_FILL_LEFTRIGHTARROW";
	public static final String CMD_FILL_UPDOWNARROW    = "CMD_FILL_UPDOWNARROW";

	public static final String CMD_SMILEY_HAPPY       = "CMD_SMILEY_HAPPY";
	public static final String CMD_SMILEY_SAD         = "CMD_SMILEY_SAD";
	public static final String CMD_SMILEY_SMILE       = "CMD_SMILEY_SMILE";
	public static final String CMD_SMILEY_WINK        = "CMD_SMILEY_WINK";
	public static final String CMD_SMILEY_CONFUSED    = "CMD_SMILEY_CONFUSED";
	public static final String CMD_SMILEY_YINGYANG    = "CMD_SMILEY_YINGYANG";
	
	public static final String CMD_FLOWCHART_PROCESS           = "CMD_FLOWCHART_PROCESS";
	public static final String CMD_FLOWCHART_ALTPROCESS        = "CMD_FLOWCHART_ALTPROCESS";
	public static final String CMD_FLOWCHART_DECISION          = "CMD_FLOWCHART_DECISION";
	public static final String CMD_FLOWCHART_DATA              = "CMD_FLOWCHART_DATA";
	public static final String CMD_FLOWCHART_PREDEFPROCESS     = "CMD_FLOWCHART_PREDEFPROCESS";
	public static final String CMD_FLOWCHART_INTSTORAGE        = "CMD_FLOWCHART_INTSTORAGE";
	public static final String CMD_FLOWCHART_DOCUMENT          = "CMD_FLOWCHART_DOCUMENT";
	public static final String CMD_FLOWCHART_MULTIDOCUMENT     = "CMD_FLOWCHART_MULTIDOCUMENT";
	public static final String CMD_FLOWCHART_TERMINATION       = "CMD_FLOWCHART_TERMINATION";
	public static final String CMD_FLOWCHART_PREPARATION       = "CMD_FLOWCHART_PREPARATION";
	public static final String CMD_FLOWCHART_MANINPUT          = "CMD_FLOWCHART_MANINPUT";
	public static final String CMD_FLOWCHART_MANOPERATION      = "CMD_FLOWCHART_MANOPERATION";
	public static final String CMD_FLOWCHART_CONNECTOR         = "CMD_FLOWCHART_CONNECTOR";
	public static final String CMD_FLOWCHART_OFFPAGECONNECTOR  = "CMD_FLOWCHART_OFFPAGECONNECTOR";
	public static final String CMD_FLOWCHART_CARD              = "CMD_FLOWCHART_CARD";
	public static final String CMD_FLOWCHART_PUNCHEDTAPE       = "CMD_FLOWCHART_PUNCHEDTAPE";
	public static final String CMD_FLOWCHART_SUMMATION         = "CMD_FLOWCHART_SUMMATION";
	public static final String CMD_FLOWCHART_OR                = "CMD_FLOWCHART_OR";
	public static final String CMD_FLOWCHART_COLLATE           = "CMD_FLOWCHART_COLLATE";
	public static final String CMD_FLOWCHART_SORT              = "CMD_FLOWCHART_SORT";
	public static final String CMD_FLOWCHART_EXTRACT           = "CMD_FLOWCHART_EXTRACT";
	public static final String CMD_FLOWCHART_MERGE             = "CMD_FLOWCHART_MERGE";
	public static final String CMD_FLOWCHART_STOREDDATA        = "CMD_FLOWCHART_STOREDDATA";
	public static final String CMD_FLOWCHART_DELAY             = "CMD_FLOWCHART_DELAY";
	public static final String CMD_FLOWCHART_SEQACSSTORAGE     = "CMD_FLOWCHART_SEQACSSTORAGE";
	public static final String CMD_FLOWCHART_DIRACSSTORAGE     = "CMD_FLOWCHART_DIRACSSTORAGE";
	public static final String CMD_FLOWCHART_MAGNETICDISK      = "CMD_FLOWCHART_MAGNETICDISK";
	public static final String CMD_FLOWCHART_DISPLAY           = "CMD_FLOWCHART_DISPLAY";
	
	public static final String CMD_SALOON            = "CMD_SALOON";
	public static final String CMD_WIG_1             = "CMD_WIG_1";
	public static final String CMD_WIG_2             = "CMD_WIG_2";
	public static final String CMD_WIG_3             = "CMD_WIG_3";
	public static final String CMD_WIG_4             = "CMD_WIG_4";
	public static final String CMD_WIG_5             = "CMD_WIG_5";
	public static final String CMD_WIG_6             = "CMD_WIG_6";
	public static final String CMD_WIG_7             = "CMD_WIG_7";
	public static final String CMD_WIG_8             = "CMD_WIG_8";
	public static final String CMD_WIG_9             = "CMD_WIG_9";
	public static final String CMD_WIG_10            = "CMD_WIG_10";
	public static final String CMD_WIG_11            = "CMD_WIG_11";
	public static final String CMD_WIG_12            = "CMD_WIG_12";
	public static final String CMD_WIG_13            = "CMD_WIG_13";
	public static final String CMD_WIG_14            = "CMD_WIG_14";
	public static final String CMD_WIG_15            = "CMD_WIG_15";
	public static final String CMD_WIG_16            = "CMD_WIG_16";
	public static final String CMD_WIG_17            = "CMD_WIG_17";
	public static final String CMD_WIG_18            = "CMD_WIG_18";
	public static final String CMD_WIG_19            = "CMD_WIG_19";
	public static final String CMD_WIG_20            = "CMD_WIG_20";
	public static final String CMD_WIG_21            = "CMD_WIG_21";
	public static final String CMD_WIG_22            = "CMD_WIG_22";
	public static final String CMD_WIG_23            = "CMD_WIG_23";
	public static final String CMD_WIG_24            = "CMD_WIG_24";
	public static final String CMD_WIG_25            = "CMD_WIG_25";
	public static final String CMD_WIG_26            = "CMD_WIG_26";
	public static final String CMD_WIG_27            = "CMD_WIG_27";
	public static final String CMD_WIG_28            = "CMD_WIG_28";
	public static final String CMD_WIG_29            = "CMD_WIG_29";
	public static final String CMD_WIG_30            = "CMD_WIG_30";
	public static final String CMD_WIG_31            = "CMD_WIG_31";
	public static final String CMD_WIG_32            = "CMD_WIG_32";
	public static final String CMD_WIG_33            = "CMD_WIG_33";
	public static final String CMD_WIG_34            = "CMD_WIG_34";
	public static final String CMD_WIG_35            = "CMD_WIG_35";
	public static final String CMD_WIG_36            = "CMD_WIG_36";
	public static final String CMD_WIG_37            = "CMD_WIG_37";
	public static final String CMD_WIG_38            = "CMD_WIG_38";
	public static final String CMD_WIG_39            = "CMD_WIG_39";
	public static final String CMD_WIG_40            = "CMD_WIG_40";
	public static final String CMD_WIG_41            = "CMD_WIG_41";
	public static final String CMD_WIG_42            = "CMD_WIG_42";
	public static final String CMD_WIG_43            = "CMD_WIG_43";
	public static final String CMD_WIG_44            = "CMD_WIG_44";
	public static final String CMD_WIG_45            = "CMD_WIG_45";
	public static final String CMD_WIG_46            = "CMD_WIG_46";
	public static final String CMD_WIG_47            = "CMD_WIG_47";
	public static final String CMD_WIG_48            = "CMD_WIG_48";
	
	public static final String CMD_HAT_1             = "CMD_HAT_1";
	public static final String CMD_HAT_2             = "CMD_HAT_2";
	public static final String CMD_HAT_3             = "CMD_HAT_3";
	public static final String CMD_HAT_4             = "CMD_HAT_4";
	public static final String CMD_HAT_5             = "CMD_HAT_5";
	public static final String CMD_HAT_6             = "CMD_HAT_6";
	public static final String CMD_HAT_7             = "CMD_HAT_7";
	public static final String CMD_HAT_8             = "CMD_HAT_8";
	public static final String CMD_HAT_9             = "CMD_HAT_9";
	public static final String CMD_HAT_10            = "CMD_HAT_10";
	public static final String CMD_HAT_11            = "CMD_HAT_11";
	public static final String CMD_HAT_12            = "CMD_HAT_12";
	public static final String CMD_HAT_13            = "CMD_HAT_13";
	public static final String CMD_HAT_14            = "CMD_HAT_14";
	public static final String CMD_HAT_15            = "CMD_HAT_15";
	public static final String CMD_HAT_16            = "CMD_HAT_16";
	public static final String CMD_HAT_17            = "CMD_HAT_17";
	public static final String CMD_HAT_18            = "CMD_HAT_18";
	public static final String CMD_HAT_19            = "CMD_HAT_19";
	public static final String CMD_HAT_20            = "CMD_HAT_20";
	public static final String CMD_HAT_21            = "CMD_HAT_21";
	public static final String CMD_HAT_22            = "CMD_HAT_22";
	public static final String CMD_HAT_23            = "CMD_HAT_23";
	public static final String CMD_HAT_24            = "CMD_HAT_24";
	public static final String CMD_HAT_25            = "CMD_HAT_25";
	public static final String CMD_HAT_26            = "CMD_HAT_26";
	public static final String CMD_HAT_27            = "CMD_HAT_27";
	public static final String CMD_HAT_28            = "CMD_HAT_28";
	public static final String CMD_HAT_29            = "CMD_HAT_29";
	public static final String CMD_HAT_30            = "CMD_HAT_30";
	public static final String CMD_HAT_31            = "CMD_HAT_31";
	public static final String CMD_HAT_32            = "CMD_HAT_32";
	public static final String CMD_HAT_33            = "CMD_HAT_33";
	public static final String CMD_HAT_34            = "CMD_HAT_34";
	public static final String CMD_HAT_35            = "CMD_HAT_35";
	public static final String CMD_HAT_36            = "CMD_HAT_36";
	public static final String CMD_HAT_37            = "CMD_HAT_37";
	public static final String CMD_HAT_38            = "CMD_HAT_38";
	public static final String CMD_HAT_39            = "CMD_HAT_39";
	public static final String CMD_HAT_40            = "CMD_HAT_40";
	public static final String CMD_HAT_41            = "CMD_HAT_41";
	public static final String CMD_HAT_42            = "CMD_HAT_42";
	public static final String CMD_HAT_43            = "CMD_HAT_43";
	public static final String CMD_HAT_44            = "CMD_HAT_44";
	public static final String CMD_HAT_45            = "CMD_HAT_45";
	public static final String CMD_HAT_46            = "CMD_HAT_46";
	public static final String CMD_HAT_47            = "CMD_HAT_47";
	public static final String CMD_HAT_48            = "CMD_HAT_48";
	public static final String CMD_HAT_49            = "CMD_HAT_49";
	public static final String CMD_HAT_50            = "CMD_HAT_50";
	public static final String CMD_HAT_51            = "CMD_HAT_51";
	public static final String CMD_HAT_52            = "CMD_HAT_52";
	public static final String CMD_HAT_53            = "CMD_HAT_53";
	public static final String CMD_HAT_54            = "CMD_HAT_54";
	public static final String CMD_HAT_55            = "CMD_HAT_55";
	public static final String CMD_HAT_56            = "CMD_HAT_56";
	public static final String CMD_HAT_57            = "CMD_HAT_57";
	public static final String CMD_HAT_58            = "CMD_HAT_58";
	public static final String CMD_HAT_59            = "CMD_HAT_59";
	public static final String CMD_HAT_60            = "CMD_HAT_60";
	public static final String CMD_HAT_61            = "CMD_HAT_61";
	public static final String CMD_HAT_62            = "CMD_HAT_62";
	
    public static final String CMD_UNDO            = "CMD_UNDO";
    public static final String CMD_REDO            = "CMD_REDO";
    public static final String CMD_SELECT          = "CMD_SELECT";
    public static final String CMD_COPY            = "CMD_COPY";
    public static final String CMD_PASTE           = "CMD_PASTE";
    public static final String CMD_ABOUT           = "CMD_ABOUT";
    public static final String CMD_SAVE            = "CMD_SAVE";
    public static final String CMD_SAVEAS          = "CMD_SAVEAS";
    public static final String CMD_PICK_COLOR      = "CMD_PICK_COLOR";




}//Config
