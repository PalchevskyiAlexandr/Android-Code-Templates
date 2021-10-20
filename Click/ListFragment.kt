

class ListFragment:Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private var _list :ArrayList<GuideModel>?=null
    private val list get() = _list!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        guideListSetup()

    }

    private fun guideListSetup() {
        _list = ContentRu.getContent()
        val adapter = ListAdapter(list) {
            doWhenClick()
        }
        binding.guideList.apply {
            this.adapter = adapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun doWhenClick() {
        findNavController().navigate(R.id.action_listFragment_to_fragmentInfo)
    }
}