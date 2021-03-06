// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bb8_common.proto

package com.zenhome.counter.ws;

public final class Bb8Common {
  private Bb8Common() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code FileType}
   */
  public enum FileType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>FT_FW_BB8 = 1;</code>
     */
    FT_FW_BB8(1),
    /**
     * <code>FT_FW_ITE = 2;</code>
     */
    FT_FW_ITE(2),
    /**
     * <code>FT_IMAGE_BMP_XZ_8BPP = 3;</code>
     */
    FT_IMAGE_BMP_XZ_8BPP(3),
    /**
     * <code>FT_IMAGE_BMP_XZ_1BPP = 4;</code>
     */
    FT_IMAGE_BMP_XZ_1BPP(4),
    ;

    /**
     * <code>FT_FW_BB8 = 1;</code>
     */
    public static final int FT_FW_BB8_VALUE = 1;
    /**
     * <code>FT_FW_ITE = 2;</code>
     */
    public static final int FT_FW_ITE_VALUE = 2;
    /**
     * <code>FT_IMAGE_BMP_XZ_8BPP = 3;</code>
     */
    public static final int FT_IMAGE_BMP_XZ_8BPP_VALUE = 3;
    /**
     * <code>FT_IMAGE_BMP_XZ_1BPP = 4;</code>
     */
    public static final int FT_IMAGE_BMP_XZ_1BPP_VALUE = 4;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static FileType valueOf(int value) {
      return forNumber(value);
    }

    public static FileType forNumber(int value) {
      switch (value) {
        case 1: return FT_FW_BB8;
        case 2: return FT_FW_ITE;
        case 3: return FT_IMAGE_BMP_XZ_8BPP;
        case 4: return FT_IMAGE_BMP_XZ_1BPP;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<FileType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        FileType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<FileType>() {
            public FileType findValueByNumber(int number) {
              return FileType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.zenhome.counter.ws.Bb8Common.getDescriptor().getEnumTypes().get(0);
    }

    private static final FileType[] VALUES = values();

    public static FileType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private FileType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:FileType)
  }

  /**
   * Protobuf enum {@code PlateState}
   */
  public enum PlateState
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>PS_SHIP = 1;</code>
     */
    PS_SHIP(1),
    /**
     * <code>PS_SHIP_TO_USER = 2;</code>
     */
    PS_SHIP_TO_USER(2),
    /**
     * <code>PS_ACTIVATED = 3;</code>
     */
    PS_ACTIVATED(3),
    /**
     * <code>PS_STOLEN = 4;</code>
     */
    PS_STOLEN(4),
    /**
     * <code>PS_DEACTIVATED = 5;</code>
     */
    PS_DEACTIVATED(5),
    /**
     * <code>PS_PREREGISTERED = 6;</code>
     */
    PS_PREREGISTERED(6),
    ;

    /**
     * <code>PS_SHIP = 1;</code>
     */
    public static final int PS_SHIP_VALUE = 1;
    /**
     * <code>PS_SHIP_TO_USER = 2;</code>
     */
    public static final int PS_SHIP_TO_USER_VALUE = 2;
    /**
     * <code>PS_ACTIVATED = 3;</code>
     */
    public static final int PS_ACTIVATED_VALUE = 3;
    /**
     * <code>PS_STOLEN = 4;</code>
     */
    public static final int PS_STOLEN_VALUE = 4;
    /**
     * <code>PS_DEACTIVATED = 5;</code>
     */
    public static final int PS_DEACTIVATED_VALUE = 5;
    /**
     * <code>PS_PREREGISTERED = 6;</code>
     */
    public static final int PS_PREREGISTERED_VALUE = 6;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static PlateState valueOf(int value) {
      return forNumber(value);
    }

    public static PlateState forNumber(int value) {
      switch (value) {
        case 1: return PS_SHIP;
        case 2: return PS_SHIP_TO_USER;
        case 3: return PS_ACTIVATED;
        case 4: return PS_STOLEN;
        case 5: return PS_DEACTIVATED;
        case 6: return PS_PREREGISTERED;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<PlateState>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        PlateState> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<PlateState>() {
            public PlateState findValueByNumber(int number) {
              return PlateState.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.zenhome.counter.ws.Bb8Common.getDescriptor().getEnumTypes().get(1);
    }

    private static final PlateState[] VALUES = values();

    public static PlateState valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private PlateState(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:PlateState)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020bb8_common.proto*\\\n\010FileType\022\r\n\tFT_FW_" +
      "BB8\020\001\022\r\n\tFT_FW_ITE\020\002\022\030\n\024FT_IMAGE_BMP_XZ_" +
      "8BPP\020\003\022\030\n\024FT_IMAGE_BMP_XZ_1BPP\020\004*y\n\nPlat" +
      "eState\022\013\n\007PS_SHIP\020\001\022\023\n\017PS_SHIP_TO_USER\020\002" +
      "\022\020\n\014PS_ACTIVATED\020\003\022\r\n\tPS_STOLEN\020\004\022\022\n\016PS_" +
      "DEACTIVATED\020\005\022\024\n\020PS_PREREGISTERED\020\006B#\n!c" +
      "om.reviver.platform.ng.libcommon"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
