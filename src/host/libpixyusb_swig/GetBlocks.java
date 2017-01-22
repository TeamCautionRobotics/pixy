public class GetBlocks {

    static {
        System.loadLibrary("pixy_java");
    }

    public static void main(String[] args) {
        BlockArray blocks = new BlockArray(100);

        pixy.pixy_init();

        while (true) {
            int count = pixy.pixy_get_blocks(100, blocks);

            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    Block block = blocks.getitem(i);

                    System.out.format("[BLOCK_TYPE=%d SIG=%d X=%3d Y=%3d WIDTH=%3d HEIGHT=%3d]%n",
                                       block.getType(), block.getSignature(), block.getX(),
                                       block.getY(), block.getWidth(), block.getHeight());
                }
            }
        }
    }
}
